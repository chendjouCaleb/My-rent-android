package com.regolia.sync.service

import com.regolia.sync.SyncObjectBox
import com.regolia.sync.models.Subject
import java.util.UUID

class SubjectService {
    fun create(name: String): Subject {
        val subject = Subject()
        subject.name = ""
        subject.localId = UUID.randomUUID().toString()

        return subject
    }

    fun save(subject: Subject) {
        SyncObjectBox.subjectBox.put(subject)
    }
}