package com.reza.multipress.di

import com.reza.multipress.data.repository.DefaultNewsRepository
import com.reza.multipress.data.repository.NewsRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<NewsRepository> { DefaultNewsRepository(apiService = get(), deviceLocale = get()) }
}
