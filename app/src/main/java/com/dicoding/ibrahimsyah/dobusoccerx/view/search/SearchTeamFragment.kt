package com.dicoding.ibrahimsyah.dobusoccerx.view.search

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dicoding.ibrahimsyah.dobusoccerx.FetchSearch
import com.dicoding.ibrahimsyah.dobusoccerx.R
import com.dicoding.ibrahimsyah.dobusoccerx.adapter.TeamRecyclerAdapter
import com.dicoding.ibrahimsyah.dobusoccerx.api.ApiRepository
import com.dicoding.ibrahimsyah.dobusoccerx.model.Event
import com.dicoding.ibrahimsyah.dobusoccerx.model.Team
import com.dicoding.ibrahimsyah.dobusoccerx.presenter.SearchPresenter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_fav_team.*

class SearchTeamFragment : Fragment(), FetchSearch {
    companion object {
        var presenter: SearchPresenter? = null
    }

    override fun showLoader() {
        favTeamRecycler.adapter = null
        favTeamProgressBar.visibility = View.VISIBLE
        favTeamNoData.visibility = View.GONE
    }

    override fun hideLoader() {
        favTeamProgressBar.visibility = View.GONE
    }

    override fun showData(matches: List<Event>?, team: List<Team>?) {
        context?.let {
            favTeamRecycler.layoutManager = LinearLayoutManager(it)
            if (team != null) {
                favTeamRecycler.adapter = TeamRecyclerAdapter(it, team) {
                    TODO("Add Intent to Team Detail")
                }
            } else {
                favTeamNoData.visibility = View.VISIBLE
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_fav_team, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = SearchPresenter(this, ApiRepository(), Gson())
    }
}