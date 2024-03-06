package com.example.android.test

import com.example.android.dataTest.getUnscrambledWord
import com.example.newapplicationjetpackcompose.viewModel.GameViewModel
import org.junit.Test

class GameViewModelTest  {
    private val viewModel = GameViewModel()

    @Test
    fun gameViewModel_CorrectWordGuessed_ScoreUpdatedAndErrorFlagUnset() {
        val currentGameUiState = viewModel.uiState.value
        val correctPlayerWord  = getUnscrambledWord(currentGameUiState.currentScrambleWord)

        viewModel.updateUserGuess(correctPlayerWord)
        viewModel.checkUserGuess()
    }

    @Test
    fun gameViewModel_CorrectWordGuessed_ScoreUpdateAndErrorFlagUnset() {
        val currentGameUiState = GameViewModel().uiState.value
        val correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambleWord)
        viewModel.updateUserGuess(correctPlayerWord)
        viewModel.checkUserGuess()

        currentGameUiState
    }
}