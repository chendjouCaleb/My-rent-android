package com.regolia.myrent.realm

import android.util.Log
import com.regolia.myrent.entities.Space
import com.regolia.myrent.realm.entities.SpaceRealm
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

class AppRealm {
    companion object {
        private var _instance: AppRealm? = null

        fun instance(): AppRealm {
            return _instance!!
        }

        fun create() {
            val config =
                RealmConfiguration.Builder(setOf(Space::class))
                    .schemaVersion(3)

                    .name("myrent")
                    .build()



            val realm = Realm.open(config)
            _instance = AppRealm(realm)

            Log.d("Realm", "Debug file: ${config.path}")
        }
    }

    lateinit var realm: Realm
    private constructor(realm: Realm) {
        this.realm = realm
    }
}