package com.dicoding.ibrahimsyah.dobusoccerx.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dicoding.ibrahimsyah.dobusoccerx.R
import com.dicoding.ibrahimsyah.dobusoccerx.adapter.MainRecyclerAdapter
import com.dicoding.ibrahimsyah.dobusoccerx.model.League
import kotlinx.android.synthetic.main.fragment_match.*

class MatchFragment : Fragment() {
    private val leagues: MutableList<League> = mutableListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        prevMatchRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        prevMatchRecycler.setHasFixedSize(true)
        prevMatchRecycler.adapter = context?.let { MainRecyclerAdapter(it, leagues) {} }
        nextMatchRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        nextMatchRecycler.setHasFixedSize(true)
        nextMatchRecycler.adapter = context?.let { MainRecyclerAdapter(it, leagues) {} }
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.leagueName)
        val id = resources.getStringArray(R.array.leagueId)
        val badge = resources.getStringArray(R.array.leagueBadgeUrl)
        for (i in name.indices) {
            leagues.add(
                League(id[i], name[i], badge[i])
            )
        }
    }
}
