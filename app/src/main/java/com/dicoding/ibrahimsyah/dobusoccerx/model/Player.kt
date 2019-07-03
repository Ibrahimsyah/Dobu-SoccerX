package com.dicoding.ibrahimsyah.dobusoccerx.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Player(
    @SerializedName("strPlayer")
    var name: String? = null,
    @SerializedName("strNationality")
    var nationality: String? = null,
    @SerializedName("strPosition")
    var position: String? = null,
    @SerializedName("strDescriptionEN")
    var description: String? = null,
    @SerializedName("strWage")
    var wage: String? = null,
    @SerializedName("strNumber")
    var number: String? = null,
    @SerializedName("strCutout")
    var photo: String? = null,
    @SerializedName("strFanart1")
    var banner: String? = null
) : Parcelable

data class PlayerResponse(val player: List<Player>)