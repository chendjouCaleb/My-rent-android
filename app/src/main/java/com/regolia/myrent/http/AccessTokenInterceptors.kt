package com.regolia.myrent.http

import android.content.SharedPreferences
import android.util.Log
import com.regolia.myrent.identity.services.AuthenticationData
import okhttp3.Interceptor
import okhttp3.Response

class AccessTokenInterceptor(private var authenticationData: AuthenticationData):Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val sharedPreferences = authenticationData.sharedPreferences
        val accessToken = sharedPreferences.getString("ACCESS_TOKEN", "")

        Log.d("AccessTokenIntercept", "Access token: $accessToken")

        if(accessToken != "") {
            val request = chain.request().newBuilder()
                .header("Authorization", "Bearer $accessToken")
                .build()
            return chain.proceed(request)
        }
        return chain.proceed(chain.request())
    }
}