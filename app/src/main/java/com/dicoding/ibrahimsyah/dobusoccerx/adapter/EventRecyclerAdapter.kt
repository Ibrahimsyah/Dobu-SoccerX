package com.dicoding.ibrahimsyah.dobusoccerx.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.dicoding.ibrahimsyah.dobusoccerx.BuildConfig
import com.dicoding.ibrahimsyah.dobusoccerx.R
import com.dicoding.ibrahimsyah.dobusoccerx.model.Event
import kotlinx.android.synthetic.main.event_item.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONObject
import java.net.URL

class EventRecyclerAdapter(
    private val context: Context,
    private val events: List<Event>,
    private val isFullViewHolder: Boolean,
    private val listener: (Event) -> Unit
) : RecyclerView.Adapter<EventRecyclerAdapter.MatchViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MatchViewHolder {
        val layoutId: Int = if (isFullViewHolder) R.layout.search_event_item else R.layout.event_item
        return MatchViewHolder(LayoutInflater.from(p0.context).inflate(layoutId, p0, false))
    }


    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(p0: MatchViewHolder, p1: Int) {
        p0.bindItem(events[p1], listener)
        grabImage(events[p1], p0)
    }

    private fun grabImage(event: Event, p0: MatchViewHolder) {
        doAsync {
            val homeBadge =
                JSONObject(URL(BuildConfig.BASE_URL + "lookupteam.php?id=" + event.homeId).readText()).getJSONArray("teams")
                    .getJSONObject(0).getString("strTeamBadge")
            val awayBadge =
                JSONObject(URL(BuildConfig.BASE_URL + "lookupteam.php?id=" + event.awayId).readText()).getJSONArray("teams")
                    .getJSONObject(0).getString("strTeamBadge")
            event.homeBadgeUrl = homeBadge
            event.awayBadgeUrl = awayBadge
            uiThread {
                Glide.with(context).load(homeBadge).override(80).diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(p0.itemView.badgeHomeTeam)
                Glide.with(context).load(awayBadge).override(80).diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(p0.itemView.badgeAwayTeam)
            }
        }
    }

    class MatchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(event: Event, listener: (Event) -> Unit) {
            itemView.matchTitle.text = event.matchTitle
            itemView.matchDate.text = event.matchDate
            itemView.homeTeamName.text = event.matchHome
            itemView.awayTeamName.text = event.matchAway
            event.homeScore?.let { itemView.scoreHome.text = it }
            event.awayScore?.let { itemView.scoreAway.text = it }

            itemView.setOnClickListener { listener(event) }
        }
    }
}