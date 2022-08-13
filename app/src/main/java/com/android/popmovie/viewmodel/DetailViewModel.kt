package com.android.popmovie.viewmodel

import androidx.lifecycle.ViewModel
import com.mobile.popmovie.data.MovieTVEntity
import com.mobile.popmovie.utils.DataDummy

class DetailViewModel : ViewModel() {
    private lateinit var movieTitle: String

    fun setMovie(movieTitle: String) {
        this.movieTitle = movieTitle
    }

    fun getMovie(): MovieTVEntity {
        lateinit var movieTVEntity: MovieTVEntity
        val movies = DataDummy.generateDummyMovie()
        val tvshow = DataDummy.generateDummyTV()

        for (movie in movies) {
            if (movie.title == movieTitle) {
                movieTVEntity = movie
            }
        }

        for (tv in tvshow) {
            if (tv.title == movieTitle) {
                movieTVEntity = tv
            }
        }

        return movieTVEntity
    }
}