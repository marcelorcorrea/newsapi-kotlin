package com.marcelorcorrea.newsapi.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ArticleResult(
    @JsonProperty("status")
    val status: String,
    @JsonProperty("code")
    val code: String?,
    @JsonProperty("message")
    val message: String?,
    @JsonProperty("totalResults")
    val totalResults: Int,
    @JsonProperty("articles")
    val articles: List<Article>
)
