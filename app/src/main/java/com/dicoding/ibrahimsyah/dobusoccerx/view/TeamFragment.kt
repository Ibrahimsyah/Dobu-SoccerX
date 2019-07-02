package com.dicoding.ibrahimsyah.dobusoccerx.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dicoding.ibrahimsyah.dobusoccerx.FetchTeam
import com.dicoding.ibrahimsyah.dobusoccerx.R
import com.dicoding.ibrahimsyah.dobusoccerx.adapter.TeamRecyclerAdapter
import com.dicoding.ibrahimsyah.dobusoccerx.api.ApiRepository
import com.dicoding.ibrahimsyah.dobusoccerx.model.Team
import com.dicoding.ibrahimsyah.dobusoccerx.presenter.TeamPresenter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_team.*
import org.jetbrains.anko.support.v4.toast

class TeamFragment : Fragment(), FetchTeam {
    override fun loadingStart() {
        teamProgressBar.visibility = View.VISIBLE
    }

    override fun loadingStop() {
        teamProgressBar.visibility = View.GONE
    }

    override fun showData(teams: List<Team>) {
        context?.let {
            teamRecycler.layoutManager = LinearLayoutManager(it)
            teamRecycler.adapter = TeamRecyclerAdapter(it, teams) {
                it.name?.let { it1 -> toast(it1) }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val leagueId = arguments?.getString("leagueId")
        val presenter = TeamPresenter(this, ApiRepository(), Gson())
        leagueId?.let { presenter.getTeams(it) }
    }
}
