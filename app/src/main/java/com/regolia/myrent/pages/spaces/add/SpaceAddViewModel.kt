package com.regolia.myrent.pages.spaces.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.regolia.myrent.models.SpaceAddModel
import com.regolia.myrent.services.SpaceService
import com.regolia.sync.SyncContext

class SpaceAddViewModel: ViewModel() {
    var spaceService = SpaceService()
    lateinit var syncContext : SyncContext
    lateinit var navHost: NavHostController


    var name by mutableStateOf("")
    var identifier by mutableStateOf("")


    suspend fun addSpace(): Boolean {
        val model = SpaceAddModel(name = name, identifier = identifier)
        val space = spaceService.addSpace(model)
        syncContext.postEvents(listOf(space.event))
        return true
    }
}