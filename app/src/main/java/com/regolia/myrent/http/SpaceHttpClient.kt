package com.regolia.myrent.http

import com.regolia.myrent.entities.Space
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface SpaceHttpClient {
    @GET("spaces")
    suspend fun list(): List<Space>

    @GET("get/identifier")
    suspend fun getIdentifier(identifier: String): Space

    @GET("exists/identifier")
    suspend fun getExists(identifier: String): Boolean

}