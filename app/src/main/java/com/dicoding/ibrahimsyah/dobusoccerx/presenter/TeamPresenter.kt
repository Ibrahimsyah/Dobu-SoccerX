package com.dicoding.ibrahimsyah.dobusoccerx.presenter

import com.dicoding.ibrahimsyah.dobusoccerx.FetchTeam
import com.dicoding.ibrahimsyah.dobusoccerx.api.ApiRepository
import com.dicoding.ibrahimsyah.dobusoccerx.api.SportDBApi
import com.dicoding.ibrahimsyah.dobusoccerx.model.TeamResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamPresenter(
    private val fetchTeam: FetchTeam,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {
    fun getTeams(leagueId: String) {
        doAsync {
            fetchTeam.loadingStart()
            val data = gson.fromJson(apiRepository.requestData(SportDBApi.getTeams(leagueId)), TeamResponse::class.java)
            uiThread {
                fetchTeam.showData(data.teams)
                fetchTeam.loadingStop()
            }
        }
    }
}