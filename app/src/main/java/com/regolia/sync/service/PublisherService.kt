package com.regolia.sync.service

import com.regolia.sync.SyncObjectBox
import com.regolia.sync.models.Publisher
import java.util.UUID

class PublisherService {
    fun create(name: String): Publisher {
        val publisher = Publisher()
        publisher.name = ""
        publisher.localId = UUID.randomUUID().toString()

        return publisher
    }

    fun save(publisher: Publisher) {
        SyncObjectBox.publisherBox.put(publisher)
    }
}