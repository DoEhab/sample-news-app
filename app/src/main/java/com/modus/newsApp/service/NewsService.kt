package com.modus.newsApp.service;

import com.modus.newsApp.models.NewsResponse
import com.modus.newsApp.models.network.BaseResponse;
import com.modus.newsApp.utils.Constants

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

interface NewsService {
    @Headers("Content-Type: application/json")

    @GET("v2/top-headlines")
    fun getBreakingNews(
        @Query(value = "country")
        countryCode: String = "us",
        @Query(value = "page")
        pageNumber: Int = 1,
        @Query(value = "apiKey")
        apiKey: String = Constants.API_KEY
    ): Flowable<NewsResponse>

    @GET("v2/everything")
    fun searchForNews(
        @Query(value = "q")
        searchQuery: String = "us",
        @Query(value = "page")
        pageNumber: Int = 1,
        @Query(value = "apiKey")
        apiKey: String = Constants.API_KEY
    ): Flowable<BaseResponse>

}
