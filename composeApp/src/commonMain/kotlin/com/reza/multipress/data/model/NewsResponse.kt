package com.reza.multipress.data.model

import kotlinx.serialization.SerialName

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)

data class Article(
    val source: ArticleSource,
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    @SerialName("urlToImage")
    val imageUrl: String?,
    val publishedAt: String,
    val content: String?
)

data class ArticleSource(
    val id: String?,
    val name: String
)