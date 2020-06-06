package com.marcelorcorrea.newsapi.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Source(
    @JsonProperty("id")
    val id: String?,
    @JsonProperty("name")
    val name: String?,
    @JsonProperty("description")
    val description: String?,
    @JsonProperty("url")
    val url: String?,
    @JsonProperty("category")
    val category: String?,
    @JsonProperty("language")
    val language: String?,
    @JsonProperty("country")
    val country: String?
)
