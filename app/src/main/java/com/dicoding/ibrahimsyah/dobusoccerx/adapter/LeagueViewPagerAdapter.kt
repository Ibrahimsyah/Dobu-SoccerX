package com.dicoding.ibrahimsyah.dobusoccerx.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class LeagueViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm){
    private val fragmentList : MutableList<Fragment> = mutableListOf()
    private val fragmentTitle : MutableList<String> = mutableListOf()

    override fun getItem(p0: Int): Fragment = fragmentList[p0]

    override fun getCount(): Int = fragmentList.size

    override fun getPageTitle(position: Int): CharSequence = fragmentTitle[position]

    fun addFragment(fragment : Fragment, title: String){
        fragmentList.add(fragment)
        fragmentTitle.add(title)
    }

}