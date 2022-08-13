package com.android.popmovie.viewmodel

import androidx.lifecycle.ViewModel
import com.mobile.popmovie.data.MovieTVEntity
import com.mobile.popmovie.utils.DataDummy

class MainViewModel : ViewModel() {
    fun getMovie() : List<MovieTVEntity> {
        return DataDummy.generateDummyMovie()
    }

    fun getTV() : List<MovieTVEntity> {
        return DataDummy.generateDummyTV()
    }
}