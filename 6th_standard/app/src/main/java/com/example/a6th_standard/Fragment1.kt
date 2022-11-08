package com.example.a6th_standard

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.a6th_standard.databinding.ActivityMainBinding
import com.example.a6th_standard.databinding.Fragment1Binding
import com.google.android.material.tabs.TabLayoutMediator


class Fragment1 : Fragment() {
    private lateinit var viewBinding: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = Fragment1Binding.inflate(layoutInflater)
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val homeVPAdapter = HomeVPAdapter(this)
        viewBinding.vpMain.adapter=homeVPAdapter
        // Adapter
        val tabTitleArray = arrayOf(
            "ONE",
            "TWO",
        )
        TabLayoutMediator(viewBinding.tabMain, viewBinding.vpMain){ tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()
    }

}