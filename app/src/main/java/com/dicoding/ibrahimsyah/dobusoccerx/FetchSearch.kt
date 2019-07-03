package com.dicoding.ibrahimsyah.dobusoccerx

import com.dicoding.ibrahimsyah.dobusoccerx.model.Event
import com.dicoding.ibrahimsyah.dobusoccerx.model.Team

interface FetchSearch {
    fun showLoader()
    fun hideLoader()
    fun showData(matches: List<Event>?, team: List<Team>?)
}