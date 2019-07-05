package com.dicoding.ibrahimsyah.dobusoccerx.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.dicoding.ibrahimsyah.dobusoccerx.model.FavTeam
import org.jetbrains.anko.db.*

class FavTeamDbHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "DobuDatabase.db", null, 1) {
    companion object {
        private var instance: FavTeamDbHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): FavTeamDbHelper {
            if (instance == null) {
                instance = FavTeamDbHelper(ctx.applicationContext)
            }
            return instance as FavTeamDbHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(
            FavTeam.TABLE_TEAM, true,
            FavTeam.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            FavTeam.TEAM_ID to TEXT,
            FavTeam.TEAM_NAME to TEXT,
            FavTeam.TEAM_DESCRIPTION to TEXT,
            FavTeam.TEAM_BADGE to TEXT,
            FavTeam.TEAM_BANNER to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(FavTeam.TABLE_TEAM, true)
    }
}

val Context.teamDB: FavTeamDbHelper
    get() = FavTeamDbHelper.getInstance(applicationContext)