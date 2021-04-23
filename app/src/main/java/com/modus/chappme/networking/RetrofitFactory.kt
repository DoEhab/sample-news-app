package com.modus.chappme.networking

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://api.arborapp.io" //staging API

object NetworkApiClient {
    private var retrofit: Retrofit? = null
    public val apiClient: Retrofit
        get() = retrofit ?: makeRetrofit()

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private fun makeRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(makeHttpClient())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    private fun makeHttpClient() = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor())
        .followRedirects(true)
        .followSslRedirects(true)
        .retryOnConnectionFailure(true)
        .connectTimeout(25, TimeUnit.SECONDS)
        .readTimeout(25, TimeUnit.SECONDS)
        .writeTimeout(25, TimeUnit.SECONDS)
        .cache(null)
        .build()

    private fun loggingInterceptor() = HttpLoggingInterceptor().apply {
        level = /*if (BuildConfig.DEBUG)*/ HttpLoggingInterceptor.Level.BODY /*else HttpLoggingInterceptor.Level.NONE*/
    }
}