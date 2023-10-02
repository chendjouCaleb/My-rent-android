package com.regolia.myrent.pages.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

class HomePageViewModel:ViewModel() {
    lateinit var nav: NavController

    var expandMenu by mutableStateOf(false)

    init {


    }
}