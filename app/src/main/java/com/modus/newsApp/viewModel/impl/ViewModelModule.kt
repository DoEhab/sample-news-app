package com.modus.newsApp.viewModel.impl

import com.modus.newsApp.dataLayer.NewsAPI
import com.modus.newsApp.viewModel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ViewModelModule {
    @Provides
    fun provideCompositeDisposaple(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    @Singleton
    fun provideNewsViewModel(
        api: NewsAPI?,
        compositeDisposable: CompositeDisposable?
    ): NewsViewModel {
        return NewsViewModel(api!!, compositeDisposable!!)
    }

    @Provides
    @Singleton
    fun provideNewsViewModelFactory(
        api: NewsAPI?,
        compositeDisposable: CompositeDisposable?
    ): NewsViewModelFactory {
        return NewsViewModelFactory(api!!, compositeDisposable!!)
    }
}