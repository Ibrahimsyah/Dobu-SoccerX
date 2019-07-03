package com.dicoding.ibrahimsyah.dobusoccerx.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.dicoding.ibrahimsyah.dobusoccerx.R
import com.dicoding.ibrahimsyah.dobusoccerx.model.Player
import kotlinx.android.synthetic.main.team_item.view.*

class PlayerRecyclerAdapter(
    val context: Context,
    val players: List<Player>,
    val listener: (Player) -> Unit
) : RecyclerView.Adapter<PlayerRecyclerAdapter.PlayerViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PlayerViewHolder {
        return PlayerViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.team_item, p0, false))
    }

    override fun getItemCount(): Int = players.size

    override fun onBindViewHolder(p0: PlayerViewHolder, p1: Int) {
        Glide.with(context).load(players[p1].photo).into(p0.itemView.teamBadge)
        p0.bindItem(players[p1], listener)
    }


    class PlayerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(player: Player, listener: (Player) -> Unit) {
            itemView.teamName.text = player.name
            itemView.setOnClickListener { listener(player) }
        }
    }
}