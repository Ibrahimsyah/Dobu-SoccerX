package com.dicoding.ibrahimsyah.dobusoccerx.presenter

import android.util.Log
import com.dicoding.ibrahimsyah.dobusoccerx.FetchSearch
import com.dicoding.ibrahimsyah.dobusoccerx.api.ApiRepository
import com.dicoding.ibrahimsyah.dobusoccerx.api.SportDBApi
import com.dicoding.ibrahimsyah.dobusoccerx.model.SearchEventResponse
import com.dicoding.ibrahimsyah.dobusoccerx.model.TeamResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class SearchPresenter(
    private val fetchSearch: FetchSearch,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {
    fun getSearchMatch(query: String) {
        fetchSearch.showLoader()
        doAsync {
            val result =
                gson.fromJson(
                    apiRepository.requestData(SportDBApi.getSearchMatch(query)),
                    SearchEventResponse::class.java
                )
            uiThread {
                Log.d("unduhan", "result: $result")
                fetchSearch.showData(result.event, null)
                fetchSearch.hideLoader()
            }
        }
    }

    fun getSearchTeam(query: String) {
        doAsync {
            fetchSearch.showLoader()
            val result =
                gson.fromJson(apiRepository.requestData(SportDBApi.getSearchTeam(query)), TeamResponse::class.java)
            uiThread {
                fetchSearch.showData(null, result.teams)
                fetchSearch.hideLoader()
            }
        }
    }
}