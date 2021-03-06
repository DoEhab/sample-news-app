package com.modus.newsApp

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate


class NewsApplication : Application() {
    companion object {
        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        }
    }
    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
        component.inject(this)
    }

    fun getComponent(): AppComponent = component
}