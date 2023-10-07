package com.regolia.myrent.services

import com.regolia.myrent.entities.Space
import com.regolia.myrent.identity.services.AuthenticationService
import com.regolia.myrent.models.SpaceAddModel
import com.regolia.myrent.repositories.SpaceRepository
import com.regolia.sync.ActionResult
import com.regolia.sync.EventService

class SpaceService {
    var spaceRepository = SpaceRepository()
    var authService = AuthenticationService.instance()
    lateinit var eventService: EventService

    suspend fun addSpace(model: SpaceAddModel): ActionResult<Space> {
        val space = Space()
        space.name = model.name
        space.identifier = model.identifier
        space.adminUserId = authService.session!!.userId

        spaceRepository.save(space)

        val event = eventService.addEvent("SPACE__ADD", space)

        return ActionResult(event, space)
    }

    fun changeName() {

    }
}