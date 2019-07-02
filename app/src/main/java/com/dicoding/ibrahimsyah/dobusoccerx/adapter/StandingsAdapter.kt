package com.dicoding.ibrahimsyah.dobusoccerx.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dicoding.ibrahimsyah.dobusoccerx.R
import com.dicoding.ibrahimsyah.dobusoccerx.model.Table
import kotlinx.android.synthetic.main.table_item.view.*

class StandingsAdapter(
    private val context: Context,
    private val tables: List<Table>
) : RecyclerView.Adapter<StandingsAdapter.TableViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TableViewHolder =
        TableViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.table_item, p0, false))

    override fun getItemCount(): Int = tables.size

    override fun onBindViewHolder(p0: TableViewHolder, p1: Int) {
        p0.bindItem(tables[p1])
    }

    class TableViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(table: Table) {
            itemView.teamName.text = table.teamName
            itemView.teamPlay.text = table.play
            itemView.teamWin.text = table.win
            itemView.teamDraw.text = table.draw
            itemView.teamLose.text = table.lose
        }
    }
}