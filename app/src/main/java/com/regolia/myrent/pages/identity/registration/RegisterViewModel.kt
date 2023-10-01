package com.regolia.myrent.pages.identity.registration

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.regolia.myrent.http.HttpModule
import com.regolia.myrent.identity.Channel
import com.regolia.myrent.identity.UserCodeHttpClient
import com.regolia.myrent.identity.UserHttpClient
import com.regolia.myrent.identity.entities.User
import com.regolia.myrent.identity.models.UserAddModel
import com.regolia.myrent.identity.models.UserCodeAddModel
import com.regolia.myrent.identity.models.UserCodeVerifyModel
import com.regolia.myrent.identity.services.UserService

class RegisterViewModel : ViewModel() {
    var userService = UserService(
        HttpModule.instance().retrofit().create(UserHttpClient::class.java),
        HttpModule.instance().retrofit().create(UserCodeHttpClient::class.java)
    )

    suspend fun checkContact(): Boolean {
        this.checkContactWaiting.value = true
        try {
            val isValid = userService.exists(this.selectedChannel.id, this.contact)
            this.checkContactWaiting.value = false
            return isValid
        } catch (e: Exception) {
            this.checkContactWaiting.value = false
        }
        return false;
    }


    suspend fun createUser(): User? {

        val model = UserAddModel()
        model.name = name
        model.userName = userName
        model.code = code
        model.contact = contact
        model.channelId = selectedChannel.id

        createAccountWaiting.value = true
        try {
            val user = userService.addUser(model)
            createAccountWaiting.value = false
            return user
        }catch (e: Exception) {
            createAccountWaiting.value = false
            return null
        }
    }
    suspend fun checkCode(): Boolean {
        this.checkCodeWaiting.value = true
        val model = UserCodeVerifyModel()
        model.contact = contact
        model.code = code
        model.purpose = "CreateUser"
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
        userService.addCreateUserCode(model)
    }


    suspend fun checkUserName(): Boolean {
        this.checkUserNameWaiting.value = true

        try {
            val exists = userService.existsByUserName(userName)
            this.checkUserNameWaiting.value = false
            return exists
        } catch (e: Exception) {
            this.checkUserNameWaiting.value = false
        }
        return false
    }

    var selectedChannel by mutableStateOf(Channel.all.first { it.id == "whatsapp" })
    var showChannelPicker = mutableStateOf(false)

    var code by mutableStateOf("")
    var contact by mutableStateOf("")
    var userName by mutableStateOf("")
    var name by mutableStateOf("")
    lateinit var nav: NavHostController

    var checkContactWaiting = mutableStateOf(false)
    var checkCodeWaiting = mutableStateOf(false)
    var checkUserNameWaiting = mutableStateOf(false)
    var createAccountWaiting = mutableStateOf(false)
}