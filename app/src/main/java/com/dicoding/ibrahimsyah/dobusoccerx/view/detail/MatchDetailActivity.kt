package com.dicoding.ibrahimsyah.dobusoccerx.view.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.dicoding.ibrahimsyah.dobusoccerx.R
import com.dicoding.ibrahimsyah.dobusoccerx.db.database
import com.dicoding.ibrahimsyah.dobusoccerx.model.Event
import com.dicoding.ibrahimsyah.dobusoccerx.model.FavMatch
import kotlinx.android.synthetic.main.activity_match_detail.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.toast

class MatchDetailActivity : AppCompatActivity() {
    private var isFav = false
    private lateinit var event: Event
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_detail)
        setSupportActionBar(detailMatchToolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        event = intent.getParcelableExtra("event")
        toolbarTitle.text = event.matchTitle

        database.use {
            val response = select(FavMatch.TABLE_MATCH).whereArgs("${FavMatch.MATCH_ID}=${event.idMatch}")
            isFav = response.parseList(classParser<FavMatch>()).isNotEmpty()
        }
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
        homeName.text = event.matchHome
        awayName.text = event.matchAway
        homeScore.text = event.homeScore
        awayScore.text = event.awayScore
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
                database.use {
                    insert(
                        FavMatch.TABLE_MATCH,
                        FavMatch.MATCH_TITLE to event.matchTitle,
                        FavMatch.MATCH_ID to event.idMatch,
                        FavMatch.MATCH_DATE to event.matchDate,
                        FavMatch.MATCH_TIME to event.matchTime,
                        FavMatch.MATCH_HOME to event.matchHome,
                        FavMatch.HOME_ID to event.homeId,
                        FavMatch.HOME_BADGE to event.homeBadgeUrl,
                        FavMatch.HOME_FORMATION to event.matchHomeFormation,
                        FavMatch.HOME_SCORE to event.homeScore,
                        FavMatch.HOME_SHOT to event.matchHomeShot,
                        FavMatch.HOME_YELLOW_CARD to event.matchHomeYelCard,
                        FavMatch.HOME_RED_CARD to event.matchHomeRedCard,
                        FavMatch.MATCH_AWAY to event.matchAway,
                        FavMatch.AWAY_ID to event.awayId,
                        FavMatch.AWAY_BADGE to event.awayBadgeUrl,
                        FavMatch.AWAY_FORMATION to event.matchAwayFormation,
                        FavMatch.AWAY_SCORE to event.awayScore,
                        FavMatch.AWAY_SHOT to event.matchAwayShot,
                        FavMatch.AWAY_YELLOW_CARD to event.matchAwayYelCard,
                        FavMatch.AWAY_RED_CARD to event.matchAwayRedCard
                    )
                }
                item.setIcon(R.drawable.ic_favorite_red)
                toast("Added to Favourite")
            } else {
                database.use {
                    delete(FavMatch.TABLE_MATCH, "${FavMatch.MATCH_ID}=${event.idMatch}")
                }
                item.setIcon(R.drawable.ic_favorite)
                toast("Removed from Favourite")
            }
            isFav = !isFav
        }
        return super.onOptionsItemSelected(item)
    }

}
