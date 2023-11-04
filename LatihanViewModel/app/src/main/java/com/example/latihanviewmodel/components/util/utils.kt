package com.example.latihanviewmodel.components.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun formatDate(time:Long):String {
    val date = Date(time)
    val format = SimpleDateFormat("EEE, d MM hh:mm aaa",Locale.getDefault())
    return format.format(date)
}