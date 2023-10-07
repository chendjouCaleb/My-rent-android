package com.regolia.objectBox.converters


import io.objectbox.converter.PropertyConverter
import java.time.ZonedDateTime

class ZonedDateTimeConverter: PropertyConverter<ZonedDateTime, String> {
    override fun convertToEntityProperty(databaseValue: String?): ZonedDateTime {
        return ZonedDateTime.parse(databaseValue)
    }

    override fun convertToDatabaseValue(entityProperty: ZonedDateTime?): String {
        return entityProperty.toString()
    }


}