package com.dicoding.ibrahimsyah.dobusoccerx.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Team(
    @SerializedName("idTeam")
    var id: String? = null,

    @SerializedName("strTeam")
    var name: String? = null,

    @SerializedName("strTeamBadge")
    var badge: String? = null,

    @SerializedName("strDescriptionEN")
    var description: String? = null,

    @SerializedName("strStadiumThumb")
    var banner: String? = null
) : Parcelable

data class TeamResponse(val teams: List<Team>)