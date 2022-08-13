package com.mobile.popmovie.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.popmovie.databinding.ItemListBinding
import com.android.popmovie.ui.DetailActivity
import com.bumptech.glide.Glide
import com.mobile.popmovie.data.MovieTVEntity

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var listMovie = ArrayList<MovieTVEntity>()

    fun setMovie(movie: List<MovieTVEntity>?) {
        if (movie == null) return
        this.listMovie.clear()
        this.listMovie.addAll(movie)
    }

    class MovieViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movieTVEntity: MovieTVEntity) {
            with(binding) {
                tvTitle.text = movieTVEntity.title
                tvYear.text = movieTVEntity.year.toString()
                tvDesc.text = movieTVEntity.desc
                Glide.with(itemView)
                    .load(movieTVEntity.image)
                    .into(ivImage)

                itemView.setOnClickListener {
                    val intent = Intent(it.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIE, movieTVEntity.title)
                    it.context.startActivity(intent)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) = holder.bind(listMovie[position])

    override fun getItemCount(): Int = listMovie.size
}
