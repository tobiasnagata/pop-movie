package com.android.popmovie.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.android.popmovie.R
import com.mobile.popmovie.utils.DataDummy
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest : TestCase() {
    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyTV = DataDummy.generateDummyTV()

    @Before
    public override fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_MovieTv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_MovieTv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadTV() {
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_MovieTv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_MovieTv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTV.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_MovieTv)).check(matches(isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.iv_detail_image)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.tv_detail_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_year)).check(matches(withText(dummyMovie[0].year.toString())))
        onView(withId(R.id.tv_detail_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_duration)).check(matches(withText(dummyMovie[0].duration)))
        onView(withId(R.id.tv_detail_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre)).check(matches(withText(dummyMovie[0].genres)))
        onView(withId(R.id.tv_detail_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_desc)).check(matches(withText(dummyMovie[0].desc)))
        onView(withId(R.id.btn_back)).perform(click())
        onView(withId(R.id.rv_MovieTv)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailTV() {
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_MovieTv)).check(matches(isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.iv_detail_image)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(dummyTV[0].title)))
        onView(withId(R.id.tv_detail_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_year)).check(matches(withText(dummyTV[0].year.toString())))
        onView(withId(R.id.tv_detail_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_duration)).check(matches(withText(dummyTV[0].duration)))
        onView(withId(R.id.tv_detail_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre)).check(matches(withText(dummyTV[0].genres)))
        onView(withId(R.id.tv_detail_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_desc)).check(matches(withText(dummyTV[0].desc)))
        onView(withId(R.id.btn_back)).perform(click())
        onView(withId(R.id.rv_MovieTv)).check(matches(isDisplayed()))
    }
}