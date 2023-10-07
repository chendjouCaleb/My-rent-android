package com.regolia.sync

import retrofit2.http.Body
import retrofit2.http.POST

interface EventHttpClient {

    @POST
    fun sendEvents(@Body model: SendEventModel): SendEventResponseModel
}