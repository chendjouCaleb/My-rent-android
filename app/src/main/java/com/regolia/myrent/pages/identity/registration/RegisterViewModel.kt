package com.regolia.myrent.pages.identity.registration

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.regolia.myrent.identity.Channel

class RegisterViewModel:ViewModel() {
    var selectedChannel by mutableStateOf(Channel.all.first { it.id == "whatsapp" })
    var showChannelPicker = mutableStateOf(false)

    var userId by mutableStateOf("")

    lateinit var nav: NavController
}