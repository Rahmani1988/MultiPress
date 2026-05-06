package com.reza.multipress.di

import com.reza.multipress.BuildKonfig
import com.reza.multipress.data.remote.ApiService
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import org.koin.dsl.module
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

val networkModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                })
            }
            defaultRequest {
                url(BuildKonfig.BASE_URL)
                header("X-Api-Key", BuildKonfig.NEWS_API_KEY)
            }
        }
    }

    single { ApiService(get()) }
}