package com.modus.chappme.dataLayer.impl

import com.modus.chappme.dataLayer.LoginAPI
import com.modus.chappme.networking.NetworkApiClient.apiClient
import com.modus.chappme.service.LoginService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataLayerModule {
    @Singleton
    @Provides
    fun providesLoginService(): LoginService {
        return apiClient.create(LoginService::class.java)
    }

    @Singleton
    @Provides
    fun providesLoginAPI(service: LoginService?): LoginAPI {
        return LoginAPIImpl(service!!)
    }
}