package com.example.latihanviewmodel.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date
import java.util.UUID

@Entity(tableName = "table_note")
data class Note(

    @PrimaryKey
    val id:UUID = UUID.randomUUID(),

    @ColumnInfo(name = "table_title")
    val title:String,

    @ColumnInfo(name = "table_desc")
    val description:String,

    @ColumnInfo(name = "table_entryDate")
    val entryDate:Date = Date.from(Instant.now())

)
