package com.dicoding.ibrahimsyah.dobusoccerx.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.dicoding.ibrahimsyah.dobusoccerx.model.FavMatch
import org.jetbrains.anko.db.*

class FavMatchDbHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "DobuDatabase.db", null, 1) {
    companion object {
        private var instance: FavMatchDbHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): FavMatchDbHelper {
            if (instance == null) {
                instance = FavMatchDbHelper(ctx.applicationContext)
            }
            return instance as FavMatchDbHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(
            FavMatch.TABLE_MATCH, true,
            FavMatch.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            FavMatch.MATCH_ID to TEXT + UNIQUE,
            FavMatch.MATCH_TITLE to TEXT,
            FavMatch.MATCH_DATE to TEXT,
            FavMatch.MATCH_TIME to TEXT,
            FavMatch.MATCH_HOME to TEXT,
            FavMatch.HOME_ID to TEXT,
            FavMatch.HOME_BADGE to TEXT,
            FavMatch.HOME_FORMATION to TEXT,
            FavMatch.HOME_SCORE to TEXT,
            FavMatch.HOME_SHOT to TEXT,
            FavMatch.HOME_YELLOW_CARD to TEXT,
            FavMatch.HOME_RED_CARD to TEXT,
            FavMatch.MATCH_AWAY to TEXT,
            FavMatch.AWAY_ID to TEXT,
            FavMatch.AWAY_BADGE to TEXT,
            FavMatch.AWAY_FORMATION to TEXT,
            FavMatch.AWAY_SCORE to TEXT,
            FavMatch.AWAY_SHOT to TEXT,
            FavMatch.AWAY_YELLOW_CARD to TEXT,
            FavMatch.AWAY_RED_CARD to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(FavMatch.TABLE_MATCH, true)
    }

}

val Context.matchDB: FavMatchDbHelper
    get() = FavMatchDbHelper.getInstance(applicationContext)