package com.modus.chappme.viewModel.impl

import com.modus.chappme.dataLayer.LoginAPI
import com.modus.chappme.viewModel.MainViewModelFactory
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
    fun provideLoginViewModel(
        api: LoginAPI?,
        compositeDisposable: CompositeDisposable?
    ): MainViewModel {
        return MainViewModel(api!!, compositeDisposable!!)
    }

    @Provides
    @Singleton
    fun provideLoginViewModelFactory(
        api: LoginAPI?,
        compositeDisposable: CompositeDisposable?
    ): MainViewModelFactory {
        return MainViewModelFactory(api!!, compositeDisposable!!)
    }
}