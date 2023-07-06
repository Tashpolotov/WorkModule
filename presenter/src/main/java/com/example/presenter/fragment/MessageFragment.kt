package com.example.presenter.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.presenter.adapter.ChatAdapter
import com.example.presenter.databinding.FragmentMessageBinding
import com.example.presenter.viewmodel.ChatViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MessageFragment : Fragment() {

    private lateinit var binding: FragmentMessageBinding
    private val adapter = ChatAdapter()

    private val viewModel by viewModels<ChatViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rv.adapter = adapter

        lifecycleScope.launchWhenStarted {
            viewModel.chatStateFlow.collect { chatViewState ->
                chatViewState.chatName?.let { chatName ->
                    binding.tvName.text = chatName.name
                }
                adapter.submitList(chatViewState.chatMessages)
            }
        }

        viewModel.getChatUseCase()
    }
}