package com.mobile.popmovie.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.popmovie.databinding.FragmentMovietvBinding
import com.android.popmovie.viewmodel.MainViewModel
import com.mobile.popmovie.adapter.MovieAdapter
import com.mobile.popmovie.utils.DataDummy
import android.R




class MovieFragment : Fragment() {
    private lateinit var fragmentMovieTvBinding: FragmentMovietvBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMovieTvBinding = FragmentMovietvBinding.inflate(layoutInflater, container, false)
        return fragmentMovieTvBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MainViewModel::class.java]
            val movie = viewModel.getMovie()

            val movieAdapter = MovieAdapter()
            movieAdapter.setMovie(movie)

            with(fragmentMovieTvBinding.rvMovieTv) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }
}