package com.dicoding.ibrahimsyah.dobusoccerx

import com.dicoding.ibrahimsyah.dobusoccerx.model.Player

interface FetchPlayer {
    fun showLoader()
    fun hideLoader()
    fun showData(players: List<Player>)
}