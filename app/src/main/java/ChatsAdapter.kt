package com.example.pr6_trembach

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatsAdapter(
    private val titles: Array<String>,
    private val onClick: () -> Unit
) : RecyclerView.Adapter<ChatsAdapter.ChatViewHolder>() {

    class ChatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tvChatTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chat, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.tvTitle.text = titles[position]
        holder.itemView.setOnClickListener { onClick() }
    }

    override fun getItemCount(): Int = titles.size
}