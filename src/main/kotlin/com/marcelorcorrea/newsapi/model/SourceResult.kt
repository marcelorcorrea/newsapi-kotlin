package com.marcelorcorrea.newsapi.model

import com.fasterxml.jackson.annotation.JsonProperty

data class SourceResult(
    @JsonProperty("status")
    var status: String,
    @JsonProperty("code")
    var code: String?,
    @JsonProperty("message")
    var message: String?,
    @JsonProperty("sources")
    var sources: List<Source>
)
