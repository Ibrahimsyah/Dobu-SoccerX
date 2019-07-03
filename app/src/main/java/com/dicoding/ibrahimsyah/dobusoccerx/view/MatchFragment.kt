package com.dicoding.ibrahimsyah.dobusoccerx.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dicoding.ibrahimsyah.dobusoccerx.FetchMatch
import com.dicoding.ibrahimsyah.dobusoccerx.R
import com.dicoding.ibrahimsyah.dobusoccerx.adapter.EventRecyclerAdapter
import com.dicoding.ibrahimsyah.dobusoccerx.api.ApiRepository
import com.dicoding.ibrahimsyah.dobusoccerx.model.EventResponse
import com.dicoding.ibrahimsyah.dobusoccerx.presenter.MatchPresenter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_match.*

class MatchFragment : Fragment(), FetchMatch {
    override fun loadingStart() {
        prevMatchTitle.visibility = View.GONE
        nextMatchTitle.visibility = View.GONE
        matchProgressBar.visibility = View.VISIBLE
    }

    override fun loadingStop() {
        prevMatchTitle.visibility = View.VISIBLE
        nextMatchTitle.visibility = View.VISIBLE
        matchProgressBar.visibility = View.GONE
    }

    override fun showData(prevMatch: EventResponse, nextMatch: EventResponse) {
        prevMatchRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        ViewCompat.setNestedScrollingEnabled(prevMatchRecycler, false)
        prevMatchRecycler.adapter = context?.let {
            prevMatch.events?.let { it1 ->
                EventRecyclerAdapter(it, it1, false) {
                    TODO("Intent To Event Detail")
                }
            }
        }
        nextMatchRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        ViewCompat.setNestedScrollingEnabled(nextMatchRecycler, false)
        nextMatchRecycler.adapter = context?.let {
            nextMatch.events?.let { it1 ->
                EventRecyclerAdapter(it, it1, false) {
                    TODO("Intent To Event Detail")
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val leagueId = arguments?.getString("leagueId")
        val presenter = MatchPresenter(ApiRepository(), this, Gson())
        presenter.getMatch(leagueId)
    }
}
