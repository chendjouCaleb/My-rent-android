package com.regolia.myrent.entities

import com.regolia.myrent.identity.entities.User
import io.realm.kotlin.types.annotations.Ignore

class Member:BasicEntity() {
    var userId: String = ""
    @Ignore var user: User? = null

    var space: Space? = null
    var spaceId: Long = 0

    var roles: HashSet<String> = hashSetOf()
}