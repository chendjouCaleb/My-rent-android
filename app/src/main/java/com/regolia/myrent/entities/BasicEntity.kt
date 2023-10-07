package com.regolia.myrent.entities

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import java.time.ZonedDateTime

open class BasicEntity : RealmObject {
    var id: Long = 0
    var firstId: Long = 0

    @PrimaryKey
    var localId: Long = 0

    var subjectId: String = ""
    var subjectLocalId: String = ""

    var publisherId: String = ""
    var publisherLocalId: String = ""


    private var _createdAt: String = ""
    var createdAt: ZonedDateTime?
        get() {
            return if (_createdAt.isEmpty()) null else ZonedDateTime.parse(_createdAt)
        }
        set(value) {
            if (value != null)
                _createdAt = value.toString()
        }

    private var _firstCreatedAt: String = ""
    var firstCreatedAt: ZonedDateTime?
        get() {
            return if (_firstCreatedAt.isEmpty()) null else ZonedDateTime.parse(_firstCreatedAt)
        }
        set(value) {
            if (value != null)
                _firstCreatedAt = value.toString()
        }


    private var _localCreatedAt: String = ""
    var localCreatedAt: ZonedDateTime?
        get() {
            return if (_localCreatedAt.isEmpty()) null else ZonedDateTime.parse(_localCreatedAt)
        }
        set(value) {
            if (value != null)
                _localCreatedAt = value.toString()
        }
}