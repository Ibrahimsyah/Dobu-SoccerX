package com.dicoding.ibrahimsyah.dobusoccerx.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.dicoding.ibrahimsyah.dobusoccerx.R
import com.dicoding.ibrahimsyah.dobusoccerx.model.Team
import kotlinx.android.synthetic.main.team_item.view.*

class TeamRecyclerAdapter(
    private val context: Context,
    private val teams: List<Team>,
    private val listener: (Team) -> Unit
) : RecyclerView.Adapter<TeamRecyclerAdapter.TeamViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TeamViewHolder =
        TeamViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.team_item, p0, false))

    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(p0: TeamViewHolder, p1: Int) {
        p0.bindItem(teams[p1], listener)
        Glide.with(context).load(teams[p1].badge).override(50).diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(p0.itemView.teamBadge)
    }


    class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(team: Team, listener: (Team) -> Unit) {
            itemView.teamName.text = team.name
            itemView.setOnClickListener { listener(team) }
        }
    }
}