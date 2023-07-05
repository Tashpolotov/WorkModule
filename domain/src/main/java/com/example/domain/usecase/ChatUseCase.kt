package com.example.domain.usecase

import com.example.domain.model.ChatMessageModel
import com.example.domain.model.ChatNameModel
import com.example.domain.repository.ChatRepository

class ChatUseCase(val repository: ChatRepository) {

    fun loadChat(): Pair<ChatNameModel, List<ChatMessageModel>> {
        val name = repository.getChatName()
        val message = repository.getChatMessage()
        return Pair(name, message)
    }
}