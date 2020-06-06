package com.marcelorcorrea.newsapi.builder

import com.marcelorcorrea.newsapi.enum.Category
import com.marcelorcorrea.newsapi.enum.Country

data class TopHeadlinesRequest(
    var category: Category? = null,
    var country: Country? = null,
    var q: String? = null,
    var sources: String? = null
)
