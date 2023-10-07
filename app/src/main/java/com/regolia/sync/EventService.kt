package com.regolia.sync

import com.fasterxml.jackson.databind.ObjectMapper
import com.regolia.sync.models.Event
import java.util.UUID

class EventService {
    lateinit var _objectMapper : ObjectMapper

    suspend fun addEvent(name: String, data: Any): Event {
        val event = Event()
        event.name = name
        event.data = _objectMapper.writeValueAsString(data)

        val localId = UUID.randomUUID().toString()
        event.localId = localId
        event.firstId = localId

        event.firstCreatedAt = event.localCreatedAt

        SyncObjectBox.eventBox.put(event)

        return event
    }
}