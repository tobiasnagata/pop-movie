package com.android.popmovie.viewmodel

import com.mobile.popmovie.utils.DataDummy
import junit.framework.TestCase
import org.junit.Before

class DetailViewModelTest : TestCase() {
    private lateinit var viewModel: DetailViewModel

    @Before
    override fun setUp() {
        viewModel = DetailViewModel()
    }

    fun testGetMovie() {
        val data = DataDummy.generateDummyMovie()[0]
        val title = "A Star Is Born"
        viewModel.setMovie(title)
        val movie = viewModel.getMovie()
        assertNotNull(movie)
        assertEquals(movie, data)
    }
}