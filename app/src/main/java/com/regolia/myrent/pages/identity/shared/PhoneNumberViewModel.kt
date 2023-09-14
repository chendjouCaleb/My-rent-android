package com.regolia.myrent.pages.identity.shared

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class PhoneNumberViewModel:ViewModel() {
    var value by mutableStateOf("")
    var indicator by mutableStateOf("+237")

    fun phoneNumber(): String {
        return indicator + value
    }
}