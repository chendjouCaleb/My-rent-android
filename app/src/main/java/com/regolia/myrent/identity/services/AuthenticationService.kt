package com.regolia.myrent.identity.services

import android.content.SharedPreferences
import com.regolia.myrent.identity.AuthenticationHttpClient
import com.regolia.myrent.identity.models.LoginModel
import com.regolia.myrent.identity.models.UserCodeAddModel
import retrofit2.Retrofit
import retrofit2.http.Body

class AuthenticationService(private var retrofit: Retrofit, private var authenticationData: AuthenticationData) {
    companion object {
        private lateinit var _instance: AuthenticationService

       fun create(retrofit: Retrofit, authenticationData: AuthenticationData) {
            this._instance = AuthenticationService(retrofit, authenticationData)
        }

        fun instance(): AuthenticationService {
            return _instance
        }
    }

    var sharedPreferences: SharedPreferences
    var authenticationHttpClient: AuthenticationHttpClient

    init {
        sharedPreferences = authenticationData.sharedPreferences
        authenticationHttpClient = retrofit.create(AuthenticationHttpClient::class.java)

    }


    suspend fun login(loginModel: LoginModel) {
       val result = authenticationHttpClient.login(loginModel)
        with(sharedPreferences.edit()) {
            putString("ACCESS_TOKEN", result.token)
            putString("SESSION_ID", result.session.id)
        }
    }

    suspend fun init() {
        val sessionId = sharedPreferences.getString("SESSION_ID", "")
        if(sessionId == "") {
            return
        }

        var session = authenticationHttpClient.LoggedSession()

    }

    fun message(): String {
        return sharedPreferences.getString("Message", "")!!
    }

    suspend fun addCreateUserCode(@Body model: UserCodeAddModel) {
        return authenticationHttpClient.CreateLoginCode(model)
    }
}