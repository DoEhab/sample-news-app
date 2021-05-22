package com.modus.newsApp.models.network

data class NetworkOutcome<T : BaseResponse>(val isRequestSuccess: Boolean,
                                            val responseBody: T?)