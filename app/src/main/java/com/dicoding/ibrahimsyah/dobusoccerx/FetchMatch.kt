package com.dicoding.ibrahimsyah.dobusoccerx

import com.dicoding.ibrahimsyah.dobusoccerx.model.EventResponse

interface FetchMatch {
    fun loadingStart()
    fun loadingStop()
    fun showData(prevMatch: EventResponse, nextMatch: EventResponse)
}