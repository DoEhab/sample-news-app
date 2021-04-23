package com.modus.chappme.models.authentication

import com.modus.chappme.models.network.BaseResponse

data class AuthenticationResponse(var user: String) : BaseResponse()

data class LoginRequest(
    var email: String,
    var password: String
)

