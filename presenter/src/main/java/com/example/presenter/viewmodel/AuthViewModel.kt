package com.example.presenter.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor (val authUseCase: AuthUseCase):ViewModel() {

    private val _loginSuccessful = MutableStateFlow(false)
    val loginSuccessful: StateFlow<Boolean> = _loginSuccessful

    fun login (username: String) {
        val success = authUseCase.login(username)
        _loginSuccessful.value = success
    }

}



