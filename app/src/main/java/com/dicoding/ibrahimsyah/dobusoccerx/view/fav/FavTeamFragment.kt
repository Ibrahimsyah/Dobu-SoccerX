package com.dicoding.ibrahimsyah.dobusoccerx.view.fav


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dicoding.ibrahimsyah.dobusoccerx.R
import com.dicoding.ibrahimsyah.dobusoccerx.adapter.TeamRecyclerAdapter
import com.dicoding.ibrahimsyah.dobusoccerx.db.database
import com.dicoding.ibrahimsyah.dobusoccerx.model.FavTeam
import com.dicoding.ibrahimsyah.dobusoccerx.model.Team
import com.dicoding.ibrahimsyah.dobusoccerx.view.team.TeamDetailActivity
import kotlinx.android.synthetic.main.fragment_fav_team.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.support.v4.startActivity

class FavTeamFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fav_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val teams = initData()
        if (teams.isEmpty()) favTeamNoData.visibility = View.VISIBLE
        else {
            favTeamRecycler.layoutManager = LinearLayoutManager(context)
            favTeamRecycler.adapter = context?.let {
                TeamRecyclerAdapter(it, teams) {
                    startActivity<TeamDetailActivity>("team" to it)
                }
            }
        }
    }

    private fun initData(): List<Team> {
        val teams: MutableList<Team> = mutableListOf()
        var data: List<FavTeam> = mutableListOf()
        context?.database?.use {
            val response = select(FavTeam.TABLE_TEAM)
            data = response.parseList(classParser())
        }
        for (d in data) {
            teams.add(
                Team(
                    d.teamId, d.teamName, d.teamBadge, d.teamDescription, d.teamBanner
                )
            )
        }
        return teams
    }
}
