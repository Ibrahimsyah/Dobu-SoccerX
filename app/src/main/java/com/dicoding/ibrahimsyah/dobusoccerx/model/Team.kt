package com.dicoding.ibrahimsyah.dobusoccerx.model

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("idTeam")
    var id: String? = null,

    @SerializedName("strTeam")
    var name: String? = null,

    @SerializedName("strTeamBadge")
    var badge: String? = null
)

data class TeamResponse(val teams: List<Team>)