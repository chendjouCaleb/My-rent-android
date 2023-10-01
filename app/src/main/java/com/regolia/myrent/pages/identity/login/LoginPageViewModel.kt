package com.regolia.myrent.pages.identity.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.regolia.myrent.R
import com.regolia.myrent.http.HttpModule
import com.regolia.myrent.identity.Channel
import com.regolia.myrent.identity.models.LoginModel
import com.regolia.myrent.identity.models.UserCodeAddModel
import com.regolia.myrent.identity.models.UserCodeVerifyModel
import com.regolia.myrent.identity.services.AuthenticationService
import com.regolia.myrent.identity.services.UserService


class LoginPageViewModel() : ViewModel() {
    var userService = UserService(HttpModule.instance().retrofit())
    private var authenticationService = AuthenticationService.instance()

    var selectedChannel by mutableStateOf(Channel.all.first { it.id == "whatsapp" })
    var showChannelPicker = mutableStateOf(false)


    var code by mutableStateOf("")
    var contact by mutableStateOf("")

    lateinit var nav: NavHostController
    lateinit var globalNav: NavController


    suspend fun checkContactExists(): Boolean {
        this.checkContactWaiting.value = true
        try {
            val isValid = userService.exists(this.selectedChannel.id, this.contact)
            this.checkContactWaiting.value = false
            return isValid
        } catch (e: Exception) {
            this.checkContactWaiting.value = false
            throw e
        }
        return false
    }

    suspend fun checkCode(): Boolean {
        this.checkCodeWaiting.value = true
        val model = UserCodeVerifyModel()
        model.contact = contact
        model.code = code
        model.purpose = "Login"
        try {
            userService.checkCode(model)
            this.checkCodeWaiting.value = false
            return true
        } catch (e: Exception) {
            this.checkCodeWaiting.value = false
        }
        return false
    }

    suspend fun sendCode() {
        val model = UserCodeAddModel()
        model.contact = this.contact
        model.channelId = this.selectedChannel.id
        authenticationService.addCreateUserCode(model)
    }

    suspend fun login() {

        val model = LoginModel()
        model.contact = contact
        model.code = code
        model.channelId = selectedChannel.id
        model.os = "android"
        authenticationService.login(model)

    }

    var checkContactWaiting = mutableStateOf(false)
    var checkCodeWaiting = mutableStateOf(false)
    var loginWaiting = mutableStateOf(false)
}