package com.dicoding.ibrahimsyah.dobusoccerx.view.league

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import com.bumptech.glide.Glide
import com.dicoding.ibrahimsyah.dobusoccerx.FetchLeague
import com.dicoding.ibrahimsyah.dobusoccerx.R
import com.dicoding.ibrahimsyah.dobusoccerx.adapter.ViewPagerAdapter
import com.dicoding.ibrahimsyah.dobusoccerx.api.ApiRepository
import com.dicoding.ibrahimsyah.dobusoccerx.model.League
import com.dicoding.ibrahimsyah.dobusoccerx.model.LeagueDetail
import com.dicoding.ibrahimsyah.dobusoccerx.presenter.LeaguePresenter
import com.dicoding.ibrahimsyah.dobusoccerx.view.search.SearchActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_league.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class LeagueActivity : AppCompatActivity(), FetchLeague {
    override fun showLoader() {
        leagueProgressBar.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        leagueProgressBar.visibility = View.GONE
    }

    override fun showData(leagueDetail: LeagueDetail?) {
        leagueDetail?.let {
            if (it.leagueBanner != null) Glide.with(applicationContext).load(it.leagueBanner).override(150).into(
                league_fanart
            )
            leagueDesc.text = it.leagueDescription
            val url = "http://${it.leagueWebsite}"
            btnWeb.onClick {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                startActivity(intent)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
        val leagueIntent = intent.getParcelableExtra<League>("league")

        league_toolbar.title = leagueIntent.name
        setSupportActionBar(league_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }

        Glide.with(this).load(leagueIntent.badge).into(leagueLogo)

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, leagueIntent.id)
        viewPagerAdapter.addFragment(MatchFragment(), "MATCH")
        viewPagerAdapter.addFragment(StandingsFragment(), "STANDINGS")
        viewPagerAdapter.addFragment(TeamFragment(), "TEAMS")
        league_viewpager.adapter = viewPagerAdapter
        league_viewpager.offscreenPageLimit = 3
        league_tabs.setupWithViewPager(league_viewpager)

        val presenter = LeaguePresenter(this, ApiRepository(), Gson())
        presenter.getLeagueDetail(leagueIntent.id)

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
