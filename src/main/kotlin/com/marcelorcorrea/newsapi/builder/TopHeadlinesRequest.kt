package com.marcelorcorrea.newsapi.builder

import com.marcelorcorrea.newsapi.enum.Category
import com.marcelorcorrea.newsapi.enum.Country

data class TopHeadlinesRequest(
    var q: String? = null,
    var category: Category? = null,
    var country: Country? = null,
    var sources: String? = null
)
