package com.modus.newsApp.dataLayer.impl

import com.modus.newsApp.dataLayer.NewsAPI
import com.modus.newsApp.networking.NetworkApiClient.apiClient
import com.modus.newsApp.service.NewsService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataLayerModule {
    @Singleton
    @Provides
    fun providesNewsService(): NewsService {
        return apiClient.create(NewsService::class.java)
    }

    @Singleton
    @Provides
    fun providesNewsAPI(service: NewsService?): NewsAPI {
        return NewsAPIImpl(service!!)
    }
}