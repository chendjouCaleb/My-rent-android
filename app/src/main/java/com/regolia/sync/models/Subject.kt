package com.regolia.sync.models

import com.regolia.objectBox.converters.ZonedDateTimeConverter
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Id
import java.time.ZonedDateTime
import java.util.UUID

class Subject {
    @Id
    var _id: Long = 0

    var localId: String = UUID.randomUUID().toString()
    var id: String = ""

    @Convert(converter = ZonedDateTimeConverter::class, dbType = String::class)
    var localCreatedAt: ZonedDateTime = ZonedDateTime.now()


    var name: String = ""
}