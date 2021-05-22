package com.modus.newsApp.dataLayer

import com.modus.newsApp.models.NewsResponse
import io.reactivex.Flowable

interface NewsAPI {
    fun fetchNews(): Flowable<NewsResponse>
}