package com.marcelorcorrea.newsapi.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Article(
    @JsonProperty("source")
    val source: Source?,
    @JsonProperty("author")
    val author: String?,
    @JsonProperty("title")
    val title: String?,
    @JsonProperty("description")
    val description: String?,
    @JsonProperty("url")
    val url: String?,
    @JsonProperty("urlToImage")
    val urlToImage: String?,
    @JsonProperty("publishedAt")
    val publishedAt: String?
)
