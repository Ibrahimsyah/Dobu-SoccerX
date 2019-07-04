package com.dicoding.ibrahimsyah.dobusoccerx.view.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.dicoding.ibrahimsyah.dobusoccerx.R
import com.dicoding.ibrahimsyah.dobusoccerx.model.Event
import kotlinx.android.synthetic.main.activity_match_detail.*

class MatchDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_detail)
        setSupportActionBar(detailMatchToolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val event = intent.getParcelableExtra<Event>("event")
        toolbarTitle.text = event.matchTitle
        matchID.text = "ID Match: ${event.idMatch}"
        matchDate.text = event.matchDate
        matchHomeID.text = event.homeId
        matchAwayID.text = event.awayId
        matchHomeName.text = event.matchHome
        matchAwayName.text = event.matchAway
        event.matchHomeFormation?.let { matchHomeFormation.text = it }
        event.matchAwayFormation?.let { matchAwayFormation.text = it }
        event.homeScore?.let { matchHomeScore.text = it; homeScore.text = it }
        event.awayScore?.let { matchAwayScore.text = it; awayScore.text = it }
        event.matchHomeShot?.let { matchHomeShot.text = it }
        event.matchAwayShot?.let { matchAwayShot.text = it }
        event.matchHomeYelCard?.let { matchHomeYelCard.text = it.split(";").size.toString() }
        event.matchAwayYelCard?.let { matchAwayYelCard.text = it.split(";").size.toString() }
        event.matchHomeRedCard?.let { matchHomeRedCard.text = it.split(";").size.toString() }
        event.matchAwayRedCard?.let { matchAwayRedCard.text = it.split(";").size.toString() }
        Glide.with(this).load(event.homeBadgeUrl).into(homeBadge)
        Glide.with(this).load(event.awayBadgeUrl).into(awayBadge)
        homeName.text = event?.matchHome
        awayName.text = event?.matchAway
        homeScore.text = event?.homeScore
        awayScore.text = event?.awayScore
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.favorite_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) super.onBackPressed()
        if (item?.itemId == R.id.menu_favourite) {
            TODO("Add to DB Button")
        }
        return super.onOptionsItemSelected(item)
    }
}
