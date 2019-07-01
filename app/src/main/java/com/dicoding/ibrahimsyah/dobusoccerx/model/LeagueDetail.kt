package com.dicoding.ibrahimsyah.dobusoccerx.model

import com.google.gson.annotations.SerializedName

data class LeagueDetail(
    @SerializedName("idLeague")
    var leagueId: String? = null,

    @SerializedName("strLeague")
    var leagueName: String? = null,

    @SerializedName("strDescriptionEN")
    var leagueDescription: String? = null,

    @SerializedName("strWebsite")
    var leagueWebsite: String? = null,

    @SerializedName("strFacebook")
    var leagueFbPage: String? = null,

    @SerializedName("strTwitter")
    var leagueTwitter: String? = null,

    @SerializedName("strYoutube")
    var leagueYoutube: String? = null,

    @SerializedName("strPoster")
    val leagueBanner: String? = null
)