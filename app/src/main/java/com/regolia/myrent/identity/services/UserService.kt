package com.regolia.myrent.identity.services

import com.regolia.myrent.http.HttpModule
import com.regolia.myrent.identity.UserCodeHttpClient
import com.regolia.myrent.identity.UserHttpClient
import com.regolia.myrent.identity.entities.User
import com.regolia.myrent.identity.models.UserAddModel
import com.regolia.myrent.identity.models.UserCodeAddModel
import com.regolia.myrent.identity.models.UserCodeVerifyModel
import retrofit2.Retrofit
import retrofit2.http.Body

class UserService {
    private lateinit var httpClient: UserHttpClient
    private lateinit var userCodeHttpClient: UserCodeHttpClient
    constructor(retrofit: Retrofit) {
        httpClient = retrofit.create(UserHttpClient::class.java)
        userCodeHttpClient = retrofit.create(UserCodeHttpClient::class.java)
    }

    suspend fun exists(channelId: String, contact: String) : Boolean {
        return httpClient.contains(channelId, contact)
    }


    suspend fun existsByUserName(userName: String): Boolean {
        return httpClient.contains(userName)
    }


    suspend fun addUser(model: UserAddModel): User {
        return httpClient.add(model)
    }

    suspend fun addCreateUserCode(@Body model: UserCodeAddModel) {
        return httpClient.addCreateUserCode(model)
    }

    suspend fun checkCode(model: UserCodeVerifyModel) {
        return userCodeHttpClient.Verify(model)
    }
}