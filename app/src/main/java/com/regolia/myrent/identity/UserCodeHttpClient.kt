package com.regolia.myrent.identity

import com.regolia.myrent.identity.models.UserCodeVerifyModel
import retrofit2.http.Body
import retrofit2.http.POST

interface UserCodeHttpClient {

    @POST("user-codes/verify")
    suspend fun Verify(@Body model: UserCodeVerifyModel)
}