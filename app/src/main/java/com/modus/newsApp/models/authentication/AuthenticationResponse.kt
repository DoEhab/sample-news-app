package com.modus.newsApp.models.authentication

import com.modus.newsApp.models.network.BaseResponse

data class AuthenticationResponse(var user: String) : BaseResponse()

data class LoginRequest(
    var email: String,
    var password: String
)

