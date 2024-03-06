package com.example.android.unscramble.ui.test

import com.example.newapplicationjetpackcompose.viewModel.GameViewModel
import org.junit.Test

class GameViewModelTest  {
    private val viewModel = GameViewModel()

    @Test
    fun gameViewModel_CorrectWordGuessed_ScoreUpdatedAndErrorFlagUnset() {
        var currentGameUiState = viewModel.uiState.value
    }
}