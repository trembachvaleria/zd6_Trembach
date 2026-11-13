package com.example.pr6_trembach

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class MainFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<android.widget.ImageButton>(R.id.btnChats).setOnClickListener {
            (activity as? MainActivity)?.goToChats()
        }
        view.findViewById<android.widget.ImageButton>(R.id.btnFavorites).setOnClickListener {
            (activity as? MainActivity)?.goToMovies()
        }
    }
}