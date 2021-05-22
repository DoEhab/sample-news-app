package com.modus.newsApp.viewModel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    val inProgress: MutableLiveData<Boolean> = MutableLiveData(false)
    val errorMessage = MutableLiveData<Int>()
    val successMessage = MutableLiveData<Int>()
    val backendErrorMessage = MutableLiveData<String>()
}