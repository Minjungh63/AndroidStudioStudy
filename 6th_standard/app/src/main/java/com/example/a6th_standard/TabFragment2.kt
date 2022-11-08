package com.example.a6th_standard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a6th_standard.databinding.FragmentTab2Binding

class TabFragment2 : Fragment() {
    private lateinit var viewBinding: FragmentTab2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentTab2Binding.inflate(layoutInflater)
        return viewBinding.root
    }

}