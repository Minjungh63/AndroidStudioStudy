package com.example.a6th_standard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a6th_standard.databinding.Fragment2Binding

class Fragment2 : Fragment() {
    private lateinit var viewBinding:Fragment2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = Fragment2Binding.inflate(layoutInflater)
        return viewBinding.root
    }

}