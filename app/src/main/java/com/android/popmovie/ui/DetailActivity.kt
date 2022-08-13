package com.android.popmovie.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.android.popmovie.databinding.ActivityDetailBinding
import com.android.popmovie.viewmodel.DetailViewModel

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(activityDetailBinding.root)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]
        val movie = intent.getStringExtra(EXTRA_MOVIE)

        if (movie != null) {
            viewModel.setMovie(movie)
            val movies = viewModel.getMovie()

            activityDetailBinding.apply {
                tvDetailTitle.text = movies.title
                tvDetailYear.text = movies.year.toString()
                tvDetailDuration.text = movies.duration
                tvDetailGenre.text = movies.genres
                tvDetailDesc.text = movies.desc
                ivDetailImage.setImageResource(movies.image)
            }
        }

        activityDetailBinding.btnBack.setOnClickListener{finish()}
    }

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }
}