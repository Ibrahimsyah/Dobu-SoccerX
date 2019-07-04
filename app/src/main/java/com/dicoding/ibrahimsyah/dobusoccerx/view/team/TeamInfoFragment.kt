package com.dicoding.ibrahimsyah.dobusoccerx.view.team

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dicoding.ibrahimsyah.dobusoccerx.R
import kotlinx.android.synthetic.main.fragment_team_info.*

class TeamInfoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_team_info, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val desc = arguments?.getString("anyString")?.split(",,,")?.get(1)
        teamDescription.text = desc
    }
}