package com.android.popmovie.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.popmovie.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.mobile.popmovie.adapter.SectionPagerAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val bundle = Bundle()

        val sectionPagerAdapter = SectionPagerAdapter(this, bundle)
        activityMainBinding.apply {
            viewPager.adapter = sectionPagerAdapter
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                when (position) {
                    0 -> tab.text = "Movie"
                    1 -> tab.text = "TV Shows"
                }
            }.attach()
        }
    }
}