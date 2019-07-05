package com.dicoding.ibrahimsyah.dobusoccerx.view.fav


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dicoding.ibrahimsyah.dobusoccerx.R
import com.dicoding.ibrahimsyah.dobusoccerx.adapter.EventRecyclerAdapter
import com.dicoding.ibrahimsyah.dobusoccerx.db.database
import com.dicoding.ibrahimsyah.dobusoccerx.model.Event
import com.dicoding.ibrahimsyah.dobusoccerx.model.FavMatch
import com.dicoding.ibrahimsyah.dobusoccerx.view.detail.MatchDetailActivity
import kotlinx.android.synthetic.main.fragment_fav_match.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.support.v4.startActivity

class FavEventFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fav_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = initData()
        if (data.isEmpty()) favMatchNoData.visibility = View.VISIBLE
        else {
            favMatchRecycler.layoutManager = LinearLayoutManager(context)
            favMatchRecycler.adapter = context?.let {
                EventRecyclerAdapter(it, data, true) {
                    startActivity<MatchDetailActivity>("event" to it)
                }
            }
        }
    }

    private fun initData(): List<Event> {
        val events: MutableList<Event> = mutableListOf()
        var data: List<FavMatch> = mutableListOf()
        context?.database?.use {
            val response = select(FavMatch.TABLE_MATCH)
            data = response.parseList(classParser())
        }
        for (m in data) {
            events.add(
                Event(
                    idMatch = m.idMatch,
                    matchTitle = m.matchTitle,
                    matchHome = m.matchHome,
                    matchAway = m.matchAway,
                    homeId = m.homeId,
                    awayId = m.awayId,
                    matchDate = m.matchDate,
                    matchTime = m.matchTime,
                    homeScore = m.homeScore,
                    awayScore = m.awayScore,
                    matchHomeFormation = m.matchHomeFormation,
                    matchAwayFormation = m.matchAwayFormation,
                    matchHomeShot = m.matchHomeShot,
                    matchAwayShot = m.matchAwayShot,
                    matchHomeYelCard = m.matchHomeYelCard,
                    matchAwayYelCard = m.matchAwayYelCard,
                    matchHomeRedCard = m.matchHomeRedCard,
                    matchAwayRedCard = m.matchAwayRedCard,
                    homeBadgeUrl = m.homeBadgeUrl,
                    awayBadgeUrl = m.awayBadgeUrl
                )
            )
        }
        return events
    }
}
