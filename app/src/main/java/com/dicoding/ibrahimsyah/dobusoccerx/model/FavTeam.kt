package com.dicoding.ibrahimsyah.dobusoccerx.model

data class FavTeam(
    val id: Long?,
    val teamId: String?,
    val teamName: String?,
    val teamDescription: String?,
    val teamBadge: String?,
    val teamBanner: String
) {
    companion object {
        const val TABLE_TEAM: String = "TABLE_TEAM"
        const val ID: String = "_ID"
        const val TEAM_ID: String = "TEAM_ID"
        const val TEAM_NAME: String = "TEAM_NAME"
        const val TEAM_DESCRIPTION: String = "TEAM_DESCRIPTION"
        const val TEAM_BADGE: String = "TEAM_BADGE"
        const val TEAM_BANNER: String = "TEAM_BANNER"
    }
}