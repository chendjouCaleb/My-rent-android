package com.regolia.sync.models

import com.regolia.objectBox.converters.ZonedDateTimeConverter
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import java.time.ZonedDateTime

@Entity
class Event {
    @Id
    var _id : Long = 0
    /**
     * Global id for the event. This id is unique on network.
     * This id is empty if the event is not shared. Only the network can set it.
     */
    var id: String = ""

    /**
     * The local id of the event. This id is set when the event entity is created.
     */
    var localId: String = ""

    /**
     * The first id of the event. Is the first localId of the event.
     */
    var firstId: String = ""

    @Convert(converter = ZonedDateTimeConverter::class, dbType = String::class)
    var createdAt: ZonedDateTime? = null

    @Convert(converter = ZonedDateTimeConverter::class, dbType = String::class)
    var localCreatedAt: ZonedDateTime = ZonedDateTime.now()

    @Convert(converter = ZonedDateTimeConverter::class, dbType = String::class)
    var firstCreatedAt: ZonedDateTime = ZonedDateTime.now()


    var name: String = ""

    var data: String = ""

    var subjectId: String = ""
    var subjectLocalId: String = ""

    var publisherId: String = ""
    var publisherLocalId: String = ""
}