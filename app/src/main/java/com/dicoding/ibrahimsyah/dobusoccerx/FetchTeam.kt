package com.dicoding.ibrahimsyah.dobusoccerx

import com.dicoding.ibrahimsyah.dobusoccerx.model.Team


interface FetchTeam {
    fun loadingStart()
    fun loadingStop()
    fun showData(teams: List<Team>)
}