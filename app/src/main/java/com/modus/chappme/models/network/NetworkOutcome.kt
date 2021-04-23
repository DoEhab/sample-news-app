package com.modus.chappme.models.network
import com.modus.chappme.models.network.BaseResponse

data class NetworkOutcome<T : BaseResponse>(val isRequestSuccess: Boolean,
                                            val responseBody: T?)