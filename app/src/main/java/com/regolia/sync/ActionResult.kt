package com.regolia.sync

import com.regolia.sync.models.Event

data class ActionResult<T> (var event: Event, var value: T)