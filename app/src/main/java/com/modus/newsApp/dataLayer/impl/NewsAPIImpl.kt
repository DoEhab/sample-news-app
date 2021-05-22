package com.modus.newsApp.dataLayer.impl

import com.modus.newsApp.dataLayer.NewsAPI
import com.modus.newsApp.models.NewsResponse
import com.modus.newsApp.service.NewsService
import io.reactivex.Flowable

class NewsAPIImpl
internal constructor(private val service: NewsService) : NewsAPI {
    override fun fetchNews(): Flowable<NewsResponse> {
        return service.getBreakingNews("us")
    }

}