package com.dicoding.ibrahimsyah.dobusoccerx.model

import com.google.gson.annotations.SerializedName

data class Table(
    @SerializedName("name")
    var teamName: String? = null,

    @SerializedName("played")
    var play: String? = null,

    @SerializedName("win")
    var win: String? = null,

    @SerializedName("draw")
    var draw: String? = null,

    @SerializedName("loss")
    var lose: String? = null
)

data class Standings(val table: List<Table>?)