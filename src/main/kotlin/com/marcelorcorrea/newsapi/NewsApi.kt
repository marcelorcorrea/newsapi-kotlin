package com.marcelorcorrea.newsapi

import com.marcelorcorrea.newsapi.builder.EverythingRequest
import com.marcelorcorrea.newsapi.builder.SourceRequest
import com.marcelorcorrea.newsapi.builder.TopHeadlinesRequest
import com.marcelorcorrea.newsapi.di.injectDependencies
import com.marcelorcorrea.newsapi.model.ArticleResult
import com.marcelorcorrea.newsapi.model.SourceResult
import com.marcelorcorrea.newsapi.service.NewsApiService
import org.koin.core.KoinComponent
import org.koin.core.inject

class NewsApi(apiKey: String) : KoinComponent {
    init {
        injectDependencies(apiKey)
    }

    private val newsApiService: NewsApiService by inject()

    suspend fun fetchSources(block: SourceRequest.() -> Unit): SourceResult {
        val (category, language, country) = SourceRequest().apply { block() }
        return newsApiService.getSources(category?.value, language?.value, country?.value)
    }

    suspend fun fetchEverything(block: EverythingRequest.() -> Unit): ArticleResult {
        val (q, sources, domains, from, to, language, sortBy) = EverythingRequest().apply { block() }
        return newsApiService.getEverything(q, sources, domains, from, to, language?.value, sortBy?.value)
    }

    suspend fun fetchTopHeadlines(block: TopHeadlinesRequest.() -> Unit): ArticleResult {
        val (q, category, country, sources) = TopHeadlinesRequest().apply { block() }
        return newsApiService.getTopHeadlines(category?.value, country?.value, sources, q)
    }
}
