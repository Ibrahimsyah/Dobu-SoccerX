package com.dicoding.ibrahimsyah.dobusoccerx.presenter

import com.dicoding.ibrahimsyah.dobusoccerx.FetchMatch
import com.dicoding.ibrahimsyah.dobusoccerx.api.ApiRepository
import com.dicoding.ibrahimsyah.dobusoccerx.api.SportDBApi
import com.dicoding.ibrahimsyah.dobusoccerx.model.EventResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MatchPresenter(
    private val apiRepository: ApiRepository,
    private val fetchMatch: FetchMatch,
    private val gson: Gson
) {
    fun getMatch(leagueId: String?) {
        fetchMatch.loadingStart()
        doAsync {
            val prevMatch =
                gson.fromJson(apiRepository.requestData(SportDBApi.getPrevMatch(leagueId)), EventResponse::class.java)
            val nextMatch =
                gson.fromJson(apiRepository.requestData(SportDBApi.getNextMatch(leagueId)), EventResponse::class.java)
            uiThread {
                fetchMatch.showData(prevMatch, nextMatch)
                fetchMatch.loadingStop()
            }
        }
    }
}