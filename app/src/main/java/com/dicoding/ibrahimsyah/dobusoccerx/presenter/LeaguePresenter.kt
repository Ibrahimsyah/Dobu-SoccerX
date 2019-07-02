package com.dicoding.ibrahimsyah.dobusoccerx.presenter

import com.dicoding.ibrahimsyah.dobusoccerx.FetchLeague
import com.dicoding.ibrahimsyah.dobusoccerx.api.ApiRepository
import com.dicoding.ibrahimsyah.dobusoccerx.api.SportDBApi
import com.dicoding.ibrahimsyah.dobusoccerx.model.LeagueDetail
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class LeaguePresenter(
    private val fetchLeague: FetchLeague,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {
    fun getLeagueDetail(leagueId: String) {
        fetchLeague.showLoader()
        doAsync {
            val data = gson.fromJson(
                apiRepository.requestLeagueDetail(SportDBApi.getLeagueDetail(leagueId)),
                LeagueDetail::class.java
            )
            uiThread {
                fetchLeague.showData(data)
                fetchLeague.hideLoader()
            }
        }
    }
}