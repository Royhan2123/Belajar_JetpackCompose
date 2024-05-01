package com.example.jetpackcomposeapi.data.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeapi.data.repository.AuthRepository
import kotlinx.coroutines.launch

class SignInViewModel : ViewModel() {
    private val authRepository = AuthRepository()

    fun login(email:String, password:String) {
        viewModelScope.launch {
            try {
                authRepository.login(email,password)
            }catch (e:Exception) {
                throw e
            }
        }
    }
}