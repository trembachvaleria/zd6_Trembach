package com.example.pr6_trembach

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MoviesAdapter(
    private val titles: Array<String>,
    private val images: Array<Int>,
    private val onClick: () -> Unit
) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.movieImage)
        val title: TextView = view.findViewById(R.id.movieTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.image.setImageResource(images[position])
        holder.title.text = titles[position]
        holder.itemView.setOnClickListener { onClick() }
    }

    override fun getItemCount(): Int = titles.size
}