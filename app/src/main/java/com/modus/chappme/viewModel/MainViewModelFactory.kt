package com.modus.chappme.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.modus.chappme.dataLayer.LoginAPI
import com.modus.chappme.viewModel.impl.MainViewModel
import io.reactivex.disposables.CompositeDisposable

class MainViewModelFactory (private val repository: LoginAPI, private val compositeDisposable: CompositeDisposable) :
ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(
            repository,
            compositeDisposable
        ) as T
    }
}
