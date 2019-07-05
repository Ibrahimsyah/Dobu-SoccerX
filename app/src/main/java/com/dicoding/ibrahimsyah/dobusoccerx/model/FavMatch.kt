package com.dicoding.ibrahimsyah.dobusoccerx.model

data class FavMatch(
    val id: Long?,
    val idMatch: String?,
    val matchTitle: String?,
    val matchDate: String?,
    val matchTime: String?,
    val matchHome: String?,
    val homeId: String?,
    val homeScore: String?,
    val homeBadgeUrl: String?,
    val matchHomeFormation: String?,
    val matchHomeShot: String?,
    val matchHomeYelCard: String?,
    val matchHomeRedCard: String?,
    val matchAway: String?,
    val awayId: String?,
    val awayScore: String?,
    val awayBadgeUrl: String?,
    val matchAwayFormation: String?,
    val matchAwayShot: String?,
    val matchAwayYelCard: String?,
    val matchAwayRedCard: String?
) {
    companion object {
        const val TABLE_MATCH: String = "TABLE_MATCH"
        const val ID: String = "ID_"
        const val MATCH_ID: String = "MATCH_ID"
        const val MATCH_TITLE: String = "MATCH_TITLE"
        const val MATCH_DATE: String = "MATCH_DATE"
        const val MATCH_TIME: String = "MATCH_TIME"
        const val MATCH_HOME: String = "MATCH_HOME"
        const val HOME_ID: String = "HOME_ID"
        const val HOME_SCORE: String = "HOME_SCORE"
        const val HOME_BADGE: String = "HOME_BADGE"
        const val HOME_FORMATION: String = "HOME_FORMATION"
        const val HOME_SHOT: String = "HOME_SHOT"
        const val HOME_YELLOW_CARD: String = "HOME_YELLOW_CARD"
        const val HOME_RED_CARD: String = "HOME_RED_CARD"
        const val MATCH_AWAY: String = "MATCH_AWAY"
        const val AWAY_ID: String = "AWAY_ID"
        const val AWAY_SCORE: String = "AWAY_SCORE"
        const val AWAY_BADGE: String = "AWAY_BADGE"
        const val AWAY_FORMATION: String = "AWAY_FORMATION"
        const val AWAY_SHOT: String = "AWAY_SHOT"
        const val AWAY_YELLOW_CARD: String = "AWAY_YELLOW_CARD"
        const val AWAY_RED_CARD: String = "AWAY_RED_CARD"
    }
}