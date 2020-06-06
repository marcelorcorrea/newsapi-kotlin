package com.marcelorcorrea.newsapi.interceptor

import okhttp3.Interceptor
import okhttp3.Response

internal class ApiKeyInterceptor(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().addHeader("X-Api-Key", apiKey).build()
        println(request.url())
        val proceed = chain.proceed(request)
        println(proceed.body()?.string())
        return chain.proceed(request)
    }
}
