package com.regolia.myrent.handlers

import com.regolia.myrent.entities.Space
import com.regolia.myrent.repositories.SpaceRepository
import com.regolia.sync.Data
import com.regolia.sync.models.Event
import com.regolia.sync.service.PublisherService
import com.regolia.sync.service.SubjectService

class SpaceEventHandler(var spaceRepository: SpaceRepository,
        var subjectService: SubjectService,
        var publisherService: PublisherService) {

    suspend fun spaceAdd(event: Event, @Data space: Space) {
        val subject = subjectService.create("SPACE__SUBJECT")
        subject.id = event.subjectId

        val publisher = publisherService.create("SPACE__PUBLISHER")
        publisher.id = event.publisherId
        
        space.subjectLocalId = subject.localId
        space.publisherLocalId = publisher.localId
        event.subjectLocalId = subject.localId
        event.publisherLocalId = publisher.localId

        spaceRepository.save(space)
        
        subjectService.save(subject)
        publisherService.save(publisher)
    }
}