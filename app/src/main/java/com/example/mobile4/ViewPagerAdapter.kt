package com.example.mobile4

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    private val fragmentList: List<Fragment>,
    supportFragmentManager: FragmentManager,lifecycle: Lifecycle
):
FragmentStateAdapter(supportFragmentManager,lifecycle)
{
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

}