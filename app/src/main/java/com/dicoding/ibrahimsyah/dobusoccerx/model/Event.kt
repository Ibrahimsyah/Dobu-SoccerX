package com.dicoding.ibrahimsyah.dobusoccerx.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Event(
    @SerializedName("idEvent")
    var idMatch: String? = "",
    @SerializedName("strEvent")
    var matchTitle: String? = "",

    @SerializedName("strHomeTeam")
    var matchHome: String? = "",
    @SerializedName("strAwayTeam")
    var matchAway: String? = "",

    @SerializedName("idHomeTeam")
    var homeId: String? = "",
    @SerializedName("idAwayTeam")
    var awayId: String? = "",

    @SerializedName("strDate")
    var matchDate: String? = "",

    @SerializedName("strTime")
    var matchTime: String? = "",

    @SerializedName("intHomeScore")
    var homeScore: String? = "",
    @SerializedName("intAwayScore")
    var awayScore: String? = "",

    @SerializedName("strHomeFormation")
    var matchHomeFormation: String? = null,
    @SerializedName("strAwayFormation")
    var matchAwayFormation: String? = null,

    @SerializedName("intHomeShots")
    var matchHomeShot: String? = null,
    @SerializedName("intAwayShots")
    var matchAwayShot: String? = null,

    @SerializedName("strHomeYellowCards")
    var matchHomeYelCard: String? = null,
    @SerializedName("strAwayYellowCards")
    var matchAwayYelCard: String? = null,

    @SerializedName("strHomeRedCards")
    var matchHomeRedCard: String? = null,
    @SerializedName("strAwayRedCards")
    var matchAwayRedCard: String? = null,

    var homeBadgeUrl: String? = "",
    var awayBadgeUrl: String? = ""
) : Parcelable

@Parcelize
data class EventResponse(val events: List<Event>?) : Parcelable

@Parcelize
data class SearchEventResponse(val event: List<Event>?) : Parcelable

