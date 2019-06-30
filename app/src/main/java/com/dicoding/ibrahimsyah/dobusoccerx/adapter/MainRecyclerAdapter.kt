package com.dicoding.ibrahimsyah.dobusoccerx.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.dicoding.ibrahimsyah.dobusoccerx.R
import com.dicoding.ibrahimsyah.dobusoccerx.model.League
import kotlinx.android.synthetic.main.league_item.view.*

class MainRecyclerAdapter(
    private val context: Context,
    private val leagues: List<League>,
    private val listener: (League) -> Unit
) :
    RecyclerView.Adapter<MainRecyclerAdapter.LeagueViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): LeagueViewHolder =
        LeagueViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.league_item, p0, false))


    override fun getItemCount(): Int = leagues.size

    override fun onBindViewHolder(p0: LeagueViewHolder, p1: Int) {
        p0.bindItem(leagues[p1], listener)
        Glide.with(context).load(leagues[p1].badge).diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(p0.itemView.leagueBadge)
    }


    class LeagueViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(league: League, listener: (League) -> Unit) {
            itemView.leagueName.text = league.name
            itemView.setOnClickListener { listener(league) }
        }
    }
}