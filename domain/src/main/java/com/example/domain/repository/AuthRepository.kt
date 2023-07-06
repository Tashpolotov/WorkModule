package com.example.domain.repository

interface AuthRepository {
    fun login(userName: String) : Boolean
}