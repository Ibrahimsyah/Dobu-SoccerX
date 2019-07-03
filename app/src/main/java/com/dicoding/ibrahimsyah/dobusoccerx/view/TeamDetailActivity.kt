package com.dicoding.ibrahimsyah.dobusoccerx.view

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.bumptech.glide.Glide
import com.dicoding.ibrahimsyah.dobusoccerx.R
import com.dicoding.ibrahimsyah.dobusoccerx.adapter.ViewPagerAdapter
import com.dicoding.ibrahimsyah.dobusoccerx.model.Team
import kotlinx.android.synthetic.main.activity_team_detail.*

class TeamDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)
        val team = intent.getParcelableExtra<Team>("team")
        team_toolbar.title = team.name
        setSupportActionBar(team_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }

        Glide.with(this).load(team.badge).override(120, 120).into(teamLogo)
        Glide.with(this).load(team.banner).into(teamFanArt)

        val adapter = ViewPagerAdapter(supportFragmentManager, "${team.id},,,${team.description}")
        adapter.addFragment(TeamInfoFragment(), "DESCRIPTION")
        adapter.addFragment(TeamPlayerFragment(), "PLAYER")
        team_viewpager.adapter = adapter
        team_tabs.setupWithViewPager(team_viewpager)
    }
}
