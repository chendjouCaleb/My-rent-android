package com.regolia.sync

import com.regolia.sync.models.Event

class SendEventModel(public var event: List<Event>)

class SendEventResponseModel {
    lateinit var events: List<Event>
}