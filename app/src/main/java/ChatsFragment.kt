package com.example.pr6_trembach

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChatsFragment : Fragment() {
    private val titles = arrayOf("Witcher", "Jessica Jones", "The Magicians")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_chats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerChats)
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = ChatsAdapter(titles) {
            (activity as? MainActivity)?.goToMain()
        }

        tvTitle.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}