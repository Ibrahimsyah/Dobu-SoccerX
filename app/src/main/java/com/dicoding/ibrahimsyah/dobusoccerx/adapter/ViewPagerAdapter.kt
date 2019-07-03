package com.dicoding.ibrahimsyah.dobusoccerx.adapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.View

class ViewPagerAdapter(fm: FragmentManager, private val anyString: String?) : FragmentPagerAdapter(fm) {
    private val fragmentList : MutableList<Fragment> = mutableListOf()
    private val fragmentTitle : MutableList<String> = mutableListOf()

    override fun getItem(p0: Int): Fragment {
        val bundle = Bundle()
        bundle.putString("anyString", anyString)
        fragmentList[p0].arguments = bundle
        return fragmentList[p0]
    }

    override fun getCount(): Int = fragmentList.size

    override fun getPageTitle(position: Int): CharSequence = fragmentTitle[position]

    fun addFragment(fragment : Fragment, title: String){
        fragmentList.add(fragment)
        fragmentTitle.add(title)
    }

    override fun destroyItem(container: View, position: Int, `object`: Any) {
    }
}