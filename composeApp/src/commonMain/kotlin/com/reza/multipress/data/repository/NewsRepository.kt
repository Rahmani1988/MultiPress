package com.reza.multipress.data.repository

import com.reza.multipress.data.model.NewsResponse

interface NewsRepository {
    suspend fun getTopHeadlines(country: String): Result<NewsResponse>
}