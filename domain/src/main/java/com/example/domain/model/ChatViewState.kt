package com.example.domain.model

data class ChatViewState(
    val chatName: ChatNameModel?,
    val chatMessages: List<ChatMessageModel>
)