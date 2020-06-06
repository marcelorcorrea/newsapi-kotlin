package com.marcelorcorrea.newsapi.service

import com.marcelorcorrea.newsapi.model.ArticleResult
import com.marcelorcorrea.newsapi.model.SourceResult
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("v2/sources")
    suspend fun getSources(
        @Query("category") category: String?,
        @Query("language") language: String?,
        @Query("country") country: String?
    ): SourceResult

    @GET("/v2/everything")
    suspend fun getEverything(
        @Query("q") q: String?,
        @Query("sources") sources: String?,
        @Query("domains") domains: String?,
        @Query("from") from: String?,
        @Query("to") to: String?,
        @Query("language") language: String?,
        @Query("sortBy") sortBy: String?
    ): ArticleResult

    @GET("/v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("category") category: String?,
        @Query("country") country: String?,
        @Query("sources") sources: String?,
        @Query("q") q: String?
    ): ArticleResult
}
