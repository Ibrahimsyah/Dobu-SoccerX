package com.dicoding.ibrahimsyah.dobusoccerx.view

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import com.dicoding.ibrahimsyah.dobusoccerx.R
import com.dicoding.ibrahimsyah.dobusoccerx.adapter.ViewPagerAdapter
import com.dicoding.ibrahimsyah.dobusoccerx.model.League
import kotlinx.android.synthetic.main.activity_league.*
import org.jetbrains.anko.startActivity

class LeagueActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
        league_toolbar.title = "English Premiere League"
        setSupportActionBar(league_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }

        val leagueIntent = intent.getParcelableExtra<League>("league")

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, leagueIntent.id)
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
