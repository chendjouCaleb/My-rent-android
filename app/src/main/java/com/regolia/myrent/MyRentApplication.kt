package com.regolia.myrent

import android.app.Application
import android.util.Log
import com.regolia.myrent.http.HttpModule
import com.regolia.myrent.http.SpaceHttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MyRentApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        HttpModule.create(this)

        var retrofit = HttpModule.instance().retrofit()
        var spaceHttpClient = retrofit.create(SpaceHttpClient::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            var spaces = spaceHttpClient.list()
            Log.d("APPLICATION", "Space count: ${spaces.size}")
        }

    }
}