package com.example.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.ChatMessageModel
import com.example.presenter.databinding.ItemBinding

class ChatAdapter:ListAdapter<ChatMessageModel, ChatAdapter.ChatViewHolder>(ChatDiffutil()) {
    inner class ChatViewHolder(val binding: ItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(model: ChatMessageModel) {
            binding.tvItemText.text = model.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return ChatViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    override fun getItemCount(): Int {
        return currentList.size
    }
}

class ChatDiffutil:DiffUtil.ItemCallback<ChatMessageModel>() {
    override fun areItemsTheSame(oldItem: ChatMessageModel, newItem: ChatMessageModel): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: ChatMessageModel, newItem: ChatMessageModel): Boolean {
        return oldItem == newItem
    }

}
