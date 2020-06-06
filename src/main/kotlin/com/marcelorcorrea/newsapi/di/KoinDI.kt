package com.marcelorcorrea.newsapi.di

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.marcelorcorrea.newsapi.interceptor.ApiKeyInterceptor
import com.marcelorcorrea.newsapi.service.NewsApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

private const val BASE_URL = "https://newsapi.org/"

@JvmField
val OBJECT_MAPPER: ObjectMapper = jacksonObjectMapper()
    .setSerializationInclusion(JsonInclude.Include.NON_NULL)
    .setSerializationInclusion(JsonInclude.Include.NON_EMPTY)
    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

fun injectDependencies(apiKey: String) {
    startKoin {
        modules(module {
            single { ApiKeyInterceptor(apiKey) as Interceptor }
            single { OkHttpClient.Builder().addInterceptor(get()).build() }
            single { JacksonConverterFactory.create(OBJECT_MAPPER) as Converter.Factory }
            single {
                Retrofit.Builder()
                    .addConverterFactory(get())
                    .client(get())
                    .baseUrl(BASE_URL)
                    .build()
                    .create(NewsApiService::class.java)
            }
        })
    }
}
