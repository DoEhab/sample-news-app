package com.modus.newsApp.viewModel.impl

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.modus.newsApp.dataLayer.NewsAPI
import com.modus.newsApp.models.NewsResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class NewsViewModel(
    val repository: NewsAPI,
    compositeDisposable: CompositeDisposable
) : BaseViewModel() {
    private var _compositeDisposable = CompositeDisposable()
    val newsList = MutableLiveData<NewsResponse>()

    init {

        _compositeDisposable = compositeDisposable
        fetchNews()
    }

    private fun fetchNews() {
        _compositeDisposable.add(
            repository.fetchNews().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({ newsData ->
                    newsList.value = newsData
                }, {
                    Log.e("bindingbindingbinding", it.message.toString())

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        _compositeDisposable.dispose()
    }
}