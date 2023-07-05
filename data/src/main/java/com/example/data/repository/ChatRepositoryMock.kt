package com.example.data.repository

import com.example.domain.model.ChatMessageModel
import com.example.domain.model.ChatNameModel
import com.example.domain.repository.ChatRepository

class   ChatRepositoryMock:ChatRepository {
    override fun getChatName(): ChatNameModel {
        return ChatNameModel("Azamat")
    }

    override fun getChatMessage(): List<ChatMessageModel> {
        return listOf(
            ChatMessageModel("Hi"),
            ChatMessageModel("Helloo"),
            ChatMessageModel("Privet"),
            ChatMessageModel("Kak dela"),

            )
    }
}