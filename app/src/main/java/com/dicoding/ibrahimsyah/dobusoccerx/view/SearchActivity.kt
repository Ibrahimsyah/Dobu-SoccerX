package com.dicoding.ibrahimsyah.dobusoccerx.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.SearchView
import android.view.MenuItem
import com.dicoding.ibrahimsyah.dobusoccerx.R
import com.dicoding.ibrahimsyah.dobusoccerx.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.fragment_fav_match.*

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        setSupportActionBar(searchToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter = ViewPagerAdapter(supportFragmentManager, null)
        adapter.addFragment(SearchEventFragment(), "MATCH")
        adapter.addFragment(SearchTeamFragment(), "TEAM")
        searchViewPager.adapter = adapter
        searchTabLayout.setupWithViewPager(searchViewPager)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(p0: String?): Boolean = false

            override fun onQueryTextSubmit(p0: String?): Boolean {
                p0?.let {
                    favMatchRecycler.adapter = null
                    SearchEventFragment.presenter?.getSearchMatch(it)
                }
                return false
            }

        })
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) super.onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}
