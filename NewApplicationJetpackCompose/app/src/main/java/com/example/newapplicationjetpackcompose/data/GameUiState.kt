package com.example.newapplicationjetpackcompose.data

data class GameUiState(
    val currentScrambleWord: String = "",
    val isGuessedWordWrong: Boolean = false
)
