package com.example.a6th_standard

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeVPAdapter(fragmentActivity: Fragment1): FragmentStateAdapter(fragmentActivity) {
    // 총 아이템 수
    override fun getItemCount(): Int= 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> TabFragment1()
            1 -> TabFragment2()
            else -> TabFragment1()
        }
    }

}