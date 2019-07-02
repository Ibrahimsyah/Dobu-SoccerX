package com.dicoding.ibrahimsyah.dobusoccerx

import com.dicoding.ibrahimsyah.dobusoccerx.model.LeagueDetail

interface FetchLeague {
    fun showLoader()
    fun hideLoader()
    fun showData(leagueDetail: LeagueDetail?)
}