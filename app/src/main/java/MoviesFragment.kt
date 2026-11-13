package com.example.pr6_trembach

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MoviesFragment : Fragment() {

    private val movieTitles = arrayOf("Witcher", "Jessica Jones", "The Magicians")
    private val movieImages = arrayOf(
        R.drawable.witcher,
        R.drawable.jessica,
        R.drawable.magicians
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerMovies)
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = MoviesAdapter(movieTitles, movieImages) {
            (activity as? MainActivity)?.goToMain()
        }

        tvTitle.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}