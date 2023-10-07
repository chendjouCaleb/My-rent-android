package com.regolia.sync

import android.content.Context
import com.regolia.sync.models.Event
import com.regolia.sync.models.Publisher
import com.regolia.sync.models.Subject
import io.objectbox.BoxStore

class SyncObjectBox {
    companion object {
        lateinit var store: BoxStore
            private set

        fun create(context: Context) {
            store = MyObjectBox.builder().androidContext(context.applicationContext)

                .name("myRent_sync")

                .build()
        }

        val eventBox = store.boxFor(Event::class.java)
        val subjectBox = store.boxFor(Subject::class.java)
        var publisherBox = store.boxFor(Publisher::class.java)

    }
}