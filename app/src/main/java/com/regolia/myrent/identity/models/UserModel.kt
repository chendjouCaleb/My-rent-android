package com.regolia.myrent.identity.models

class UserAddModel {
    var name: String = ""
    var userName: String = ""
    var contact: String = ""
    var channelId: String = ""
    var code: String = ""
}

class UserChangeContactModel {
    var contact: String = ""
    var channelId: String = ""
    var code: String = ""
}

class LoginModel {
    var contact: String = ""
    var channelId: String = ""
    var code: String = ""
    var os: String = ""
}


class UserCodeAddModel {
    var contact: String = ""
    var channelId: String = ""
}

class UserCodeVerifyModel {
    var contact: String = ""
    var purpose: String = ""
    var code: String = ""
}