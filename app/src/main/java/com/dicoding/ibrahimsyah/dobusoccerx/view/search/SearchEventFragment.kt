package com.dicoding.ibrahimsyah.dobusoccerx.view.search

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dicoding.ibrahimsyah.dobusoccerx.FetchSearch
import com.dicoding.ibrahimsyah.dobusoccerx.R
import com.dicoding.ibrahimsyah.dobusoccerx.adapter.EventRecyclerAdapter
import com.dicoding.ibrahimsyah.dobusoccerx.api.ApiRepository
import com.dicoding.ibrahimsyah.dobusoccerx.model.Event
import com.dicoding.ibrahimsyah.dobusoccerx.model.Team
import com.dicoding.ibrahimsyah.dobusoccerx.presenter.SearchPresenter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_fav_match.*

class SearchEventFragment : Fragment(), FetchSearch {
    companion object {
        var presenter: SearchPresenter? = null
    }

    override fun showLoader() {
        favMatchRecycler.adapter = null
        favMatchProgressBar.visibility = View.VISIBLE
        favMatchNoData.visibility = View.GONE
    }

    override fun hideLoader() {
        favMatchProgressBar.visibility = View.GONE
    }

    override fun showData(matches: List<Event>?, team: List<Team>?) {
        context?.let {
            favMatchRecycler.layoutManager = LinearLayoutManager(it)
            if (matches?.size != 0) {
                favMatchRecycler.adapter = matches?.let { it1 ->
                    EventRecyclerAdapter(it, it1, true) {
                        TODO("Add Intent to Event Detail")
                    }
                }
            } else {
                favMatchNoData.visibility = View.VISIBLE
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_fav_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = SearchPresenter(this, ApiRepository(), Gson())
    }
}