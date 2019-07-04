package com.dicoding.ibrahimsyah.dobusoccerx.view.fav

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.dicoding.ibrahimsyah.dobusoccerx.R
import com.dicoding.ibrahimsyah.dobusoccerx.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_favourite.*

class FavouriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)
        setSupportActionBar(favouriteToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val favVP = ViewPagerAdapter(supportFragmentManager, "0")
        favVP.addFragment(FavEventFragment(), "MATCH")
        favVP.addFragment(FavTeamFragment(), "TEAM")
        favViewPager.adapter = favVP
        favTabLayout.setupWithViewPager(favViewPager)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) super.onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}
