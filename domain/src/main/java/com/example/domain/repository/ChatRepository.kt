package com.example.domain.repository

import com.example.domain.model.ChatMessageModel
import com.example.domain.model.ChatNameModel

interface ChatRepository {

    fun getChatName() : ChatNameModel

    fun getChatMessage() : List<ChatMessageModel>
}