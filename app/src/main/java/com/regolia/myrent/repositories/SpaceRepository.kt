package com.regolia.myrent.repositories

import com.regolia.myrent.entities.Space
import com.regolia.myrent.realm.AppRealm

class SpaceRepository {
    private var realm = AppRealm.instance().realm

    suspend fun save(space: Space) {
        realm.write {
            copyToRealm(space)
        }
    }
}