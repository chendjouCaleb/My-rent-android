package com.regolia.myrent.identity

import com.regolia.myrent.identity.entities.User
import com.regolia.myrent.identity.models.UserAddModel
import com.regolia.myrent.identity.models.UserCodeAddModel
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserHttpClient {
    @GET("users/{id}")
    suspend fun getById(@Path("id") id: String): User


    @POST("users/exists/userName")
    @FormUrlEncoded
    suspend fun contains( @Field("userName") userName: String):Boolean


    @POST("users/exists/channel")
    @FormUrlEncoded
    suspend fun contains(@Field("channelId") channelId: String, @Field("contact") contact: String):Boolean


    @POST("users/get/channel")
    @FormUrlEncoded
    suspend fun get(@Field("channelId") channelId: String, @Field("contact") contact: String):User

    @POST("users")
    @FormUrlEncoded
    suspend fun add(@Body model: UserAddModel): User

    @POST("users/code/create-user")
    suspend fun addCreateUserCode(@Body model: UserCodeAddModel): Unit

}