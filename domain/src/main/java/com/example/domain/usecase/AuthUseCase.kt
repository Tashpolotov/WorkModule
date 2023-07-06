package com.example.domain.usecase

import com.example.domain.repository.AuthRepository

class AuthUseCase(val repository: AuthRepository) {

        fun login(username: String) : Boolean {
            return repository.login(username)
        }
}