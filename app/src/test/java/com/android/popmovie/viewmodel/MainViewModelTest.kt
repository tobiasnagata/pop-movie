package com.android.popmovie.viewmodel

import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class MainViewModelTest : TestCase() {
    private lateinit var viewModel: MainViewModel

    @Before
    override fun setUp() {
        viewModel = MainViewModel()
    }

    @Test
    fun testGetMovie() {
        val movie = viewModel.getMovie()
        assertNotNull(movie)
        assertEquals(19, movie.size)
    }

    @Test
    fun testGetTv() {
        val tv = viewModel.getTV()
        assertNotNull(tv)
        assertEquals(20, tv.size)
    }
}