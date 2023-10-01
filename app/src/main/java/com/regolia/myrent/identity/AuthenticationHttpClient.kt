package com.regolia.myrent.identity

import com.regolia.myrent.identity.entities.Session
import com.regolia.myrent.identity.entities.User
import com.regolia.myrent.identity.models.LoginModel
import com.regolia.myrent.identity.models.UserCodeAddModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface AuthenticationHttpClient {

    @GET("authentication/user")
    suspend fun LoggedUser(): User


    @GET("authentication/session")
    suspend fun LoggedSession(): Session

    @POST
    suspend fun CreateLoginCode(@Body model: UserCodeAddModel)

    @POST
    suspend fun login(@Body model: LoginModel)

    @PUT
    suspend fun Logout()
}