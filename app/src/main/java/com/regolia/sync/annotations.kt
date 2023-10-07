package com.regolia.sync

@Target(AnnotationTarget.FUNCTION)
annotation class Receiver(val name: String)

@Target(AnnotationTarget.FUNCTION)
annotation class Update(val name: String)

@Target(AnnotationTarget.FUNCTION)
annotation class EventUpdate(val name: String)


@Target(AnnotationTarget.VALUE_PARAMETER)
annotation class Data

@Target(AnnotationTarget.VALUE_PARAMETER)
annotation class Item

@Target(AnnotationTarget.VALUE_PARAMETER)
annotation class ItemId