package com.modus.chappme.service;

import com.modus.chappme.models.authentication.AuthenticationResponse;
import com.modus.chappme.models.authentication.LoginRequest;
import com.modus.chappme.models.network.BaseResponse;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LoginService {
    @Headers("Content-Type: application/json")

    @POST("/auth/sign_in")
    Flowable<BaseResponse> login(@Body LoginRequest request);

}
