package com.dicoding.ibrahimsyah.dobusoccerx.presenter

import com.dicoding.ibrahimsyah.dobusoccerx.FetchPlayer
import com.dicoding.ibrahimsyah.dobusoccerx.api.ApiRepository
import com.dicoding.ibrahimsyah.dobusoccerx.api.SportDBApi
import com.dicoding.ibrahimsyah.dobusoccerx.model.PlayerResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class PlayerPresenter(
    private val fetchPlayer: FetchPlayer,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {
    fun getPlayer(teamId: String) {
        fetchPlayer.showLoader()
        doAsync {
            val data =
                gson.fromJson(apiRepository.requestData(SportDBApi.getPlayers(teamId)), PlayerResponse::class.java)
            uiThread {
                fetchPlayer.showData(data.player)
                fetchPlayer.hideLoader()
            }
        }
    }
}