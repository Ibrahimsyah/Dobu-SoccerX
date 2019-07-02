package com.dicoding.ibrahimsyah.dobusoccerx.presenter

import com.dicoding.ibrahimsyah.dobusoccerx.FetchStandings
import com.dicoding.ibrahimsyah.dobusoccerx.api.ApiRepository
import com.dicoding.ibrahimsyah.dobusoccerx.api.SportDBApi
import com.dicoding.ibrahimsyah.dobusoccerx.model.Standings
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class StandingsPresenter(
    private val fetchStandings: FetchStandings,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {
    fun getStandings(leagueId: String) {
        doAsync {
            val data =
                gson.fromJson(apiRepository.requestData(SportDBApi.getStandings(leagueId)), Standings::class.java)
            uiThread {
                fetchStandings.showData(data)
            }
        }
    }
}