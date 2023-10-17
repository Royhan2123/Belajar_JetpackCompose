package com.example.latihanroomcompose

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Contact(

    @PrimaryKey(autoGenerate = true)
    val id:Int? = null,


    val firstname:String,


    val lastname:String,


    val phoneNumber:String,

)
