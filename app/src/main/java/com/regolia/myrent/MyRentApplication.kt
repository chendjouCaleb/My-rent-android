package com.regolia.myrent

import android.app.Application
import android.util.Log
import com.regolia.myrent.http.HttpModule
import com.regolia.myrent.http.SpaceHttpClient
import com.regolia.myrent.identity.services.AuthenticationData
import com.regolia.myrent.identity.services.AuthenticationService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyRentApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        var authenticationData = AuthenticationData(this)
        HttpModule.create(this, authenticationData)

        var retrofit = HttpModule.instance().retrofit()
        var spaceHttpClient = retrofit.create(SpaceHttpClient::class.java)

        AuthenticationService.create(retrofit, authenticationData)

        CoroutineScope(Dispatchers.IO).launch {
            var spaces = spaceHttpClient.list()
            Log.d("APPLICATION", "Space count: ${spaces.size}")
        }

    }
}