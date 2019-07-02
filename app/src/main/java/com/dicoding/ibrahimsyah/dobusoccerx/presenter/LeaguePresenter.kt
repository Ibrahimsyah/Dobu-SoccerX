package com.dicoding.ibrahimsyah.dobusoccerx.presenter

import com.dicoding.ibrahimsyah.dobusoccerx.FetchLeague
import com.dicoding.ibrahimsyah.dobusoccerx.api.ApiRepository
import org.jetbrains.anko.doAsync

class LeaguePresenter(
    private val fetchLeague: FetchLeague,
    private val apiRepository: ApiRepository
) {
    fun getLeagueDetail(leagueId: String) {
        fetchLeague.showLoader()
        doAsync {

        }
    }
}