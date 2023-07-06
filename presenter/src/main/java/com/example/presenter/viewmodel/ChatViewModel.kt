package com.example.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.ChatMessageModel
import com.example.domain.model.ChatNameModel
import com.example.domain.model.ChatViewState
import com.example.domain.usecase.ChatUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ChatViewModel @Inject constructor(private val chatUseCase: ChatUseCase) : ViewModel() {
    private val _chatStateFlow = MutableStateFlow(ChatViewState(null, emptyList()))
    val chatStateFlow: StateFlow<ChatViewState> = _chatStateFlow

    fun getChatUseCase() {
        viewModelScope.launch {
            val (chatName, chatMessages) = chatUseCase.loadChat()
            _chatStateFlow.value = ChatViewState(chatName, chatMessages)
        }
    }
}