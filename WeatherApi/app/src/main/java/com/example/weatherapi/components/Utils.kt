package com.example.weatherapi.components

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@SuppressLint("SimpleDateFormat")
fun formatDate(time: Long): String {
    val date = Date(time)
    val format = SimpleDateFormat("EEE,d MMM hh:mm aaa")
        Locale.getDefault()
    return format.format(date)
}