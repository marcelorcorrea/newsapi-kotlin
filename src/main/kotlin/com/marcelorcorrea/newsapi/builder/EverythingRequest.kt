package com.marcelorcorrea.newsapi.builder

import com.marcelorcorrea.newsapi.enum.Language
import com.marcelorcorrea.newsapi.enum.SortBy

data class EverythingRequest(
    var q: String? = null,
    var sources: String? = null,
    var domains: String? = null,
    var from: String? = null,
    var to: String? = null,
    var language: Language? = null,
    var sortBy: SortBy? = null
)
