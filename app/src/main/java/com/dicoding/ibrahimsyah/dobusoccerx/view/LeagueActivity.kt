package com.dicoding.ibrahimsyah.dobusoccerx.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.dicoding.ibrahimsyah.dobusoccerx.R
import com.dicoding.ibrahimsyah.dobusoccerx.SearchActivity
import com.dicoding.ibrahimsyah.dobusoccerx.adapter.LeagueViewPagerAdapter
import kotlinx.android.synthetic.main.activity_league.*
import org.jetbrains.anko.startActivity

class LeagueActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
        league_toolbar.title = "English Premiere League"
        setSupportActionBar(league_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewPagerAdapter = LeagueViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(MatchFragment(), "MATCH")
        viewPagerAdapter.addFragment(StandingsFragment(), "STANDINGS")
        viewPagerAdapter.addFragment(TeamFragment(), "TEAMS")
        league_viewpager.adapter = viewPagerAdapter
        league_tabs.setupWithViewPager(league_viewpager)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) super.onBackPressed()
        if (item?.itemId == R.id.menu_search) startActivity<SearchActivity>()
        return super.onOptionsItemSelected(item)
    }
}
