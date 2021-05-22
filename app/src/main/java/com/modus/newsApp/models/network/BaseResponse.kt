package com.modus.newsApp.models.network

import com.squareup.moshi.Json

open class BaseResponse(@Json(name = "status_code")  val statusCode: String = "",
                        val message: String = "")