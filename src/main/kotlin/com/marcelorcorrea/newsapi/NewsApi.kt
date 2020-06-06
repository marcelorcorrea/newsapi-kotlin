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
        val sourceRequest = SourceRequest().apply { block() }
        return newsApiService.getSources(
            sourceRequest.category?.value,
            sourceRequest.language?.value,
            sourceRequest.country?.value
        )
    }

    suspend fun fetchEverything(block: EverythingRequest.() -> Unit): ArticleResult {
        val everything = EverythingRequest().apply { block() }
        return newsApiService.getEverything(
            everything.q,
            everything.sources,
            everything.domains,
            everything.from,
            everything.to,
            everything.language?.value,
            everything.sortBy?.value
        )
    }

    suspend fun fetchTopHeadlines(block: TopHeadlinesRequest.() -> Unit): ArticleResult {
        val topHeadlines = TopHeadlinesRequest().apply { block() }
        return newsApiService.getTopHeadlines(
            topHeadlines.category?.value,
            topHeadlines.country?.value,
            topHeadlines.sources,
            topHeadlines.q
        )
    }
}
