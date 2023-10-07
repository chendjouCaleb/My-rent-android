package com.regolia.myrent.entities

import java.time.LocalDate

class Tenant {
    var firstName: String = ""
    var lastName: String = ""
    var birthDate: LocalDate = LocalDate.now()
    var sex: String = ""
    var phoneNumber: String = ""
    var email: String = ""
    var spaceId: Long = 0

}