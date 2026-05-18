package com.reza.multipress.data.repository

import com.reza.multipress.data.model.NewsResponse
import com.reza.multipress.data.remote.ApiService
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

class DefaultNewsRepository(
    private val apiService: ApiService
) : NewsRepository {

    private var cachedRates: NewsResponse? = null
    private var lastFetchedTime: Long = 0L
    private val cacheTimeout = 5 * 60 * 1000 // 5 minutes in milliseconds

    @OptIn(ExperimentalTime::class)
    override suspend fun getTopHeadlines(country: String): Result<NewsResponse> {
        val currentTime = Clock.System.now().toEpochMilliseconds()

        // Check if cache is still valid
        if (cachedRates != null && (currentTime - lastFetchedTime < cacheTimeout)) {
            return Result.success(cachedRates!!)
        }

        // Otherwise, fetch from network with error handling
        return try {
            val response = apiService.getTopHeadlines(country)

            cachedRates = response
            lastFetchedTime = currentTime

            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}