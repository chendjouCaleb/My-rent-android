package com.regolia.myrent.identity.models

import com.regolia.myrent.identity.entities.Session

class LoginResultModel {
    lateinit var session: Session
    lateinit var token: String
}