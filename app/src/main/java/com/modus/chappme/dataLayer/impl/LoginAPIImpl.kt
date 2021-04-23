package com.modus.chappme.dataLayer.impl

import com.modus.chappme.dataLayer.LoginAPI
import com.modus.chappme.models.authentication.LoginRequest
import com.modus.chappme.models.network.BaseResponse
import com.modus.chappme.service.LoginService
import io.reactivex.Flowable

class LoginAPIImpl
internal constructor(private val service: LoginService) : LoginAPI {
    override fun login(): Flowable<BaseResponse> {
        val loginRequest = LoginRequest("DohaEhab@gmail.com", "123qweAA")
        return service.login(loginRequest)
    }

    //    public Completable logout() {
//        return service.logout();
//    }

}