package com.regolia.myrent.pages.identity.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.regolia.myrent.R
import com.regolia.myrent.identity.Channel


class LoginPageViewModel:ViewModel() {
    var selectedChannel by mutableStateOf(Channel.all.first { it.id == "whatsapp" })
    var showChannelPicker = mutableStateOf(false)

    var userId by mutableStateOf("")

    lateinit var nav: NavHostController
}