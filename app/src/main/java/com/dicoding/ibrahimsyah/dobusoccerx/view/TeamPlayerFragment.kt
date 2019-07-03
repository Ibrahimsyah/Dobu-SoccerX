package com.dicoding.ibrahimsyah.dobusoccerx.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dicoding.ibrahimsyah.dobusoccerx.FetchPlayer
import com.dicoding.ibrahimsyah.dobusoccerx.R
import com.dicoding.ibrahimsyah.dobusoccerx.adapter.PlayerRecyclerAdapter
import com.dicoding.ibrahimsyah.dobusoccerx.api.ApiRepository
import com.dicoding.ibrahimsyah.dobusoccerx.model.Player
import com.dicoding.ibrahimsyah.dobusoccerx.presenter.PlayerPresenter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_team.*

class TeamPlayerFragment : Fragment(), FetchPlayer {
    override fun showLoader() {
        teamProgressBar.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        teamProgressBar.visibility = View.GONE
    }

    override fun showData(players: List<Player>) {
        context?.let {
            teamRecycler.layoutManager = LinearLayoutManager(it)
            teamRecycler.adapter = PlayerRecyclerAdapter(it, players) {}
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_team, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val teamId = arguments?.getString("anyString")?.split(",,,")?.get(0)

        val presenter = PlayerPresenter(this, ApiRepository(), Gson())
        teamId?.let { presenter.getPlayer(it) }
    }
}