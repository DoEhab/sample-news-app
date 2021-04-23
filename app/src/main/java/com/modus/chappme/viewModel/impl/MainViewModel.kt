package com.modus.chappme.viewModel.impl

import android.util.Log
import androidx.lifecycle.ViewModel
import com.modus.chappme.dataLayer.LoginAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(
    val repository: LoginAPI,
    compositeDisposable: CompositeDisposable
) : BaseViewModel() {
    private var _compositeDisposable = CompositeDisposable()

    init {
        Log.e("MainViewModel", "MU MODEL")

        _compositeDisposable = compositeDisposable
        login()
    }

    fun login() {
        _compositeDisposable.add(
            repository.login().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({
                Log.e("MainViewModel", it.message)
            }
                , {
                        Log.e("MainViewModel", it.message.toString())

                    })
        )
    }

    override fun onCleared() {
        super.onCleared()
        _compositeDisposable.dispose()
    }
}