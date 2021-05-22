package com.modus.newsApp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.modus.newsApp.dataLayer.NewsAPI
import com.modus.newsApp.viewModel.impl.NewsViewModel
import io.reactivex.disposables.CompositeDisposable

class NewsViewModelFactory (private val repository: NewsAPI, private val compositeDisposable: CompositeDisposable) :
ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(
            repository,
            compositeDisposable
        ) as T
    }
}
