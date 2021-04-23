package com.modus.chappme.dataLayer

import com.modus.chappme.models.network.BaseResponse
import io.reactivex.Flowable

interface LoginAPI {
    fun login(): Flowable<BaseResponse>
    //    Completable logout();
}