package com.example.myapplication.model

import java.time.LocalDateTime
import java.util.UUID

data class Note(
    val id:UUID = UUID.randomUUID(),
    var title:String,
    val description:String,
    val entryDate:LocalDateTime = LocalDateTime.now()

)
