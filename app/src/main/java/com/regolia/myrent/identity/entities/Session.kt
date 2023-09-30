package com.regolia.myrent.identity.entities

import java.time.ZonedDateTime

class Session {
    var id: String = ""
    var createdAt: ZonedDateTime = ZonedDateTime.now()
    var closedAt: ZonedDateTime? = null

    var os: String = ""
    var browser: String = ""

    var userId: String = ""
}