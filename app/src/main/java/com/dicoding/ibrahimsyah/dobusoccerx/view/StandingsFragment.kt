package com.dicoding.ibrahimsyah.dobusoccerx.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dicoding.ibrahimsyah.dobusoccerx.FetchStandings
import com.dicoding.ibrahimsyah.dobusoccerx.R
import com.dicoding.ibrahimsyah.dobusoccerx.adapter.StandingsRecyclerAdapter
import com.dicoding.ibrahimsyah.dobusoccerx.api.ApiRepository
import com.dicoding.ibrahimsyah.dobusoccerx.model.Standings
import com.dicoding.ibrahimsyah.dobusoccerx.presenter.StandingsPresenter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_standings.*


class StandingsFragment : Fragment(), FetchStandings {
    override fun showData(table: Standings) {
        context?.let {
            standingsRecycler.layoutManager = LinearLayoutManager(it)
            standingsRecycler.adapter = table.table?.let { it1 ->
                StandingsRecyclerAdapter(it, it1)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_standings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val leagueId = arguments?.getString("anyString")
        val presenter = StandingsPresenter(this, ApiRepository(), Gson())
        leagueId?.let { presenter.getStandings(it) }
    }
}
