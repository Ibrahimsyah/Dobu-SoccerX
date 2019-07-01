package com.dicoding.ibrahimsyah.dobusoccerx.api

import org.json.JSONObject
import java.net.URL

class ApiRepository {
    fun requestLeagueDetail(url: String): String = JSONObject(URL(url).readText()).getJSONArray("leagues")[0].toString()

    fun requestMatch(url: String): String = URL(url).readText()
}