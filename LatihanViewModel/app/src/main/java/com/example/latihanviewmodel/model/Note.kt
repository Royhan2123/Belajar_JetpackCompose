package com.example.latihanviewmodel.model

import java.time.LocalDateTime
import java.util.UUID

data class Note(
    val id:UUID = UUID.randomUUID(),
    val note:String,
    val description:String,
    val entryDate:LocalDateTime = LocalDateTime.now()
)
