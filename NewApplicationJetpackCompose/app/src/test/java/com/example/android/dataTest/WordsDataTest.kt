package com.example.android.dataTest

import com.example.newapplicationjetpackcompose.data.allWords

internal fun getUnscrambledWord(scrambledWord: String) = wordLengthMap[scrambledWord.length] ?: ""
private val wordLengthMap: Map<Int, String> = allWords.associateBy({ it.length }, { it })
