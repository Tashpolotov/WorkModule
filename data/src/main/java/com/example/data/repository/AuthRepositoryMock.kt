package com.example.data.repository

import com.example.domain.repository.AuthRepository

class AuthRepositoryMock: AuthRepository {
    override fun login(userName: String): Boolean {
        return true
    }


}