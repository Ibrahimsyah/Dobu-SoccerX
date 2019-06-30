package com.dicoding.ibrahimsyah.dobusoccerx.view

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.dicoding.ibrahimsyah.dobusoccerx.R
import com.dicoding.ibrahimsyah.dobusoccerx.adapter.LeagueViewPagerAdapter
import kotlinx.android.synthetic.main.activity_league.*

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
        val searchManager: SearchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView: android.support.v7.widget.SearchView =
            menu?.findItem(R.id.menu_search)?.actionView as android.support.v7.widget.SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.search_hint)
        searchView.setOnQueryTextListener(object : android.support.v7.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onQueryTextChange(newText: String?): Boolean = false

        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) super.onBackPressed()
        if (item?.itemId == R.id.menu_search)
            supportFragmentManager.beginTransaction().replace(
                R.id.container,
                TeamFragment()
            ).addToBackStack(null).commit()
        return super.onOptionsItemSelected(item)
    }
}
