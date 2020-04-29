package com.hoon.dustsearch.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.hoon.dustsearch.base.BaseFragment
import com.hoon.dustsearch.ui.fragment.FineDustFragment
import com.hoon.dustsearch.ui.fragment.WeatherFragment

class MainFragPagerAdapter : FragmentPagerAdapter {

    private val list: ArrayList<BaseFragment> = ArrayList()

    constructor(fragmentManager: FragmentManager) : super(fragmentManager) {
        list.add(FineDustFragment())
        list.add(WeatherFragment())
    }

    override fun getItem(position: Int): Fragment {
        return list.get(position)
    }

    override fun getCount(): Int {
        return list.size
    }
}
