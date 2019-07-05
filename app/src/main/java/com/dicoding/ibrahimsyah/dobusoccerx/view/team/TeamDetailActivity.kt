package com.dicoding.ibrahimsyah.dobusoccerx.view.team

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import com.bumptech.glide.Glide
import com.dicoding.ibrahimsyah.dobusoccerx.R
import com.dicoding.ibrahimsyah.dobusoccerx.adapter.ViewPagerAdapter
import com.dicoding.ibrahimsyah.dobusoccerx.db.teamDB
import com.dicoding.ibrahimsyah.dobusoccerx.model.FavTeam
import com.dicoding.ibrahimsyah.dobusoccerx.model.Team
import kotlinx.android.synthetic.main.activity_team_detail.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.toast

class TeamDetailActivity : AppCompatActivity() {

    private var isFav = false
    private lateinit var team: Team
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)
        team = intent.getParcelableExtra<Team>("team")
        team_toolbar.title = team.name
        setSupportActionBar(team_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }

        teamDB.use {
            val response = select(FavTeam.TABLE_TEAM).whereArgs("${FavTeam.TEAM_ID}=${team.id}")
            isFav = response.parseList(classParser<FavTeam>()).isNotEmpty()
        }

        team.badge?.let { Glide.with(this).load(it).override(120, 120).into(teamLogo) }
        team.banner?.let { Glide.with(this).load(it).into(teamFanArt) }

        val adapter = ViewPagerAdapter(supportFragmentManager, "${team.id},,,${team.description}")
        adapter.addFragment(TeamInfoFragment(), "DESCRIPTION")
        adapter.addFragment(TeamPlayerFragment(), "PLAYER")
        team_viewpager.adapter = adapter
        team_tabs.setupWithViewPager(team_viewpager)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.favorite_menu, menu)
        if (isFav) menu.getItem(0).setIcon(R.drawable.ic_favorite_red)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) super.onBackPressed()
        if (item?.itemId == R.id.menu_favourite) {
            if (!isFav) {
                teamDB.use {
                    insert(
                        FavTeam.TABLE_TEAM,
                        FavTeam.TEAM_ID to team.id,
                        FavTeam.TEAM_NAME to team.name,
                        FavTeam.TEAM_DESCRIPTION to team.description,
                        FavTeam.TEAM_BADGE to team.badge,
                        FavTeam.TEAM_BANNER to team.banner
                    )
                }
                item.setIcon(R.drawable.ic_favorite_red)
                toast("Added to Favourite")
            } else {
                teamDB.use {
                    delete(FavTeam.TABLE_TEAM, "${FavTeam.TEAM_ID}=${team.id}")
                    item.setIcon(R.drawable.ic_favorite)
                    toast("Removed from Favourite")
                }
            }
            isFav = !isFav
        }
        return super.onOptionsItemSelected(item)
    }
}
