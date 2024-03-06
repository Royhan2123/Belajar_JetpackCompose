package com.example.newapplicationjetpackcompose.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.newapplicationjetpackcompose.data.GameUiState
import com.example.newapplicationjetpackcompose.data.MAX_NO_OF_WORDS
import com.example.newapplicationjetpackcompose.data.SCORE_INCREASE
import com.example.newapplicationjetpackcompose.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {
    var userGuess by mutableStateOf("")
        private set

    fun updateUserGuess(guessWord:String) {
        userGuess = guessWord
    }

    private lateinit var currentWord:String
    private var usedWords: MutableSet<String> = mutableSetOf()

    // mutableStateFlow adalah alur holder yang digunakan untuk memperbarui pembaruan
    // saat ini dan yang baru,makanya tidak menggunakan mutableStateOf()
    private val _uiState = MutableStateFlow(GameUiState())

    // asStateFlow membuat alur status yang dapat berubah ini menjadi alur status hanya baca
    val uiState:StateFlow<GameUiState> = _uiState.asStateFlow()

    init {
        resetGame()
    }

    private fun pickRandomWordAndShuffle(): String {
        currentWord = allWords.random()
        return if (usedWords.contains(currentWord)) {
            pickRandomWordAndShuffle()
        } else {
            usedWords.add(currentWord)
            shuffleCurrentWord(currentWord)
        }
    }

    private fun shuffleCurrentWord(word:String) : String {
        val tempWord = word.toCharArray()

        tempWord.shuffle()
        while (String(tempWord) == word) {
            tempWord.shuffle()
        }
        return String(tempWord)
    }
     private fun resetGame() {
        usedWords.clear()
        _uiState.value = GameUiState(currentScrambleWord = pickRandomWordAndShuffle())
    }

    fun checkUserGuess() {
        if (userGuess.equals(currentWord, ignoreCase = true)) {
            val updateScore = _uiState.value.score.plus(SCORE_INCREASE)
            updateGameState(updateScore)
        } else {
            // User's guess is wrong, show an error
            _uiState.update { currentState ->
                currentState.copy(isGuessedWordWrong = true)
            }
        }
        updateUserGuess("")
    }

    private fun updateGameState(updateSocre:Int) {
        if (usedWords.size == MAX_NO_OF_WORDS) {
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    score = updateSocre,
                    isGameOver = true
                )
            }
        } else {
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    currentWordCount = currentState.currentWordCount.inc(),
                    currentScrambleWord = pickRandomWordAndShuffle(),
                    score = updateSocre
                )
            }
        }
    }

    fun skipWord() {
        updateGameState(_uiState.value.score)
        updateUserGuess("")
    }

}