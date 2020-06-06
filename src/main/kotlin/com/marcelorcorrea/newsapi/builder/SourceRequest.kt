package com.marcelorcorrea.newsapi.builder

import com.marcelorcorrea.newsapi.enum.Category
import com.marcelorcorrea.newsapi.enum.Country
import com.marcelorcorrea.newsapi.enum.Language

data class SourceRequest(
    var category: Category? = null,
    var language: Language? = null,
    var country: Country? = null
)
