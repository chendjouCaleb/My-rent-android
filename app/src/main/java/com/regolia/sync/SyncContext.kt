package com.regolia.sync

import com.regolia.sync.models.Event
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SyncContext {
    lateinit var eventService: EventService
    lateinit var eventHttpClient: EventHttpClient

    suspend fun addEvent(name: String, data: Any): Event {
        return eventService.addEvent(name, data)
    }

    fun postEvents(events : List<Event>) {
        CoroutineScope(Dispatchers.IO).launch {
            val model = SendEventModel(events)
            val response = eventHttpClient.sendEvents(model)

            for (event in events) {
                val globalEvent = response.events.first { it.firstId == event.firstId }
                event.id = globalEvent.id
                event.createdAt = globalEvent.createdAt
            }

            SyncObjectBox.eventBox.put(events)
        }

    }
}