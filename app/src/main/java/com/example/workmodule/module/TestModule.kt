package com.example.workmodule.module

import com.example.data.repository.AuthRepositoryMock
import com.example.data.repository.ChatRepositoryMock
import com.example.domain.repository.AuthRepository
import com.example.domain.repository.ChatRepository
import com.example.domain.usecase.AuthUseCase
import com.example.domain.usecase.ChatUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class TestModule {

    @Provides
    fun getRepository() : ChatRepository{
        return ChatRepositoryMock()
    }

    @Provides
    fun getUseCase(repository: ChatRepository): ChatUseCase {
        return ChatUseCase(repository)
    }

    @Provides
    fun getAuthRepository() : AuthRepository {
        return AuthRepositoryMock()
    }

    @Provides
    fun getAuthUseCase(repository: AuthRepository): AuthUseCase {
        return AuthUseCase(repository)
    }
}