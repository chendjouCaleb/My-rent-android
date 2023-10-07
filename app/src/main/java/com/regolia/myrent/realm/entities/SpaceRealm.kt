package com.regolia.myrent.realm.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import com.regolia.myrent.entities.Space
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId
import java.time.LocalDateTime
import java.time.ZonedDateTime

class SpaceRealm{

    var id: ObjectId  = BsonObjectId()
    var name: String = ""
    var identifier: String = ""
    var createdAt:ZonedDateTime = ZonedDateTime.now()

    fun asSpace(): Space {
        val _this = this
        return Space().apply {
            name = _this.name
            identifier = _this.identifier
            createdAt = _this.createdAt
        }
    }

    fun fromSpace(space: Space) {

    }
}