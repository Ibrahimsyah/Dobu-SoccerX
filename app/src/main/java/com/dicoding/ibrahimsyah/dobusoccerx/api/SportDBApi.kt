package com.dicoding.ibrahimsyah.dobusoccerx.api

import com.dicoding.ibrahimsyah.dobusoccerx.BuildConfig

object SportDBApi {
    fun getTeamDetail(teamId: String?): String = BuildConfig.BASE_URL + "lookupteam.php?id=" + teamId

    fun getLeagueDetail(leagueId: String?): String = BuildConfig.BASE_URL + "lookupleague.php?id=" + leagueId

    fun getNextMatch(leagueId: String?): String = BuildConfig.BASE_URL + "eventsnextleague.php?id=" + leagueId

    fun getPrevMatch(leagueId: String?): String = BuildConfig.BASE_URL + "eventspastleague.php?id=" + leagueId

    fun getSearchRes(query: String?): String = BuildConfig.BASE_URL + "searchevents.php?e=" + query

    fun getMatchDetail(matchId: String?): String = BuildConfig.BASE_URL + "lookupevent.php?id=" + matchId
}