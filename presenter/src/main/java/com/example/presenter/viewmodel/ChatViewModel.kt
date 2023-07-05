package com.example.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.ChatMessageModel
import com.example.domain.model.ChatNameModel
import com.example.domain.usecase.ChatUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ChatViewModel @Inject constructor(private val chatUseCase: ChatUseCase) : ViewModel() {

    private val _chatName = MutableStateFlow<ChatNameModel?>(null)
    val chatName: StateFlow<ChatNameModel?> = _chatName.asStateFlow()

    private val _chatMessage = MutableStateFlow<List<ChatMessageModel>>(emptyList())
    val chatMessage: StateFlow<List<ChatMessageModel>> = _chatMessage.asStateFlow()

    fun getChatUseCase() {
        viewModelScope.launch {
            val result = chatUseCase.loadChat()
            _chatName.value = result.first
            _chatMessage.value = result.second
        }
    }
}