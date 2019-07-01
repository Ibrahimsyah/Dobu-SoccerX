package com.dicoding.ibrahimsyah.dobusoccerx.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.dicoding.ibrahimsyah.dobusoccerx.R
import com.dicoding.ibrahimsyah.dobusoccerx.adapter.MainRecyclerAdapter
import com.dicoding.ibrahimsyah.dobusoccerx.model.League
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    private val leagues : MutableList<League> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainToolbar.title = "Dobu SoccerX"
        setSupportActionBar(mainToolbar)
        initData()
        mainRecycler.layoutManager = GridLayoutManager(this, 2)
        mainRecycler.adapter = MainRecyclerAdapter(this, leagues){
            startActivity<LeagueActivity>("league" to it)
        }
    }
    private fun initData(){
        val name = resources.getStringArray(R.array.leagueName)
        val id = resources.getStringArray(R.array.leagueId)
        val badge = resources.getStringArray(R.array.leagueBadgeUrl)
        for(i in name.indices){
            leagues.add(
                League(id[i], name[i], badge[i])
            )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.favorite_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.menu_favourite) startActivity<FavouriteActivity>()
        return super.onOptionsItemSelected(item)
    }
}
