package com.example.android.test

import com.example.android.dataTest.getUnscrambledWord
import com.example.newapplicationjetpackcompose.data.SCORE_INCREASE
import com.example.newapplicationjetpackcompose.viewModel.GameViewModel
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
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

        assertFalse(currentGameUiState.isGuessedWordWrong)
        assertEquals(20,currentGameUiState.score)
    }

    companion object {
        private const val SCORE_AFTER_FIRST_CORRECT_ANSWER = SCORE_INCREASE
    }
}