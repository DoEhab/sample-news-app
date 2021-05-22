package com.modus.newsApp

import com.modus.newsApp.ui.activity.MainActivity
import com.modus.newsApp.ui.fragment.NewsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(newsApplication: NewsApplication)
    fun inject(mainActivity: MainActivity)
    fun inject(newsFragment: NewsFragment)
}