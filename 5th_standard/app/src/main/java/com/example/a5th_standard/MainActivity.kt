package com.example.a5th_standard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a5th_standard.databinding.ActivityMainBinding

data class BusinessCard(val name:String, val contents:String)

class MainActivity : AppCompatActivity() {
    var businessCardArrayList = ArrayList<BusinessCard>()
    // Main에서도 어뎁터를 만들고, 그 어뎁터를 리스트뷰에 세팅
    // 이때 lateinit을 하는 이유는, arraylist를 만든 다음, 데이터를 추가한 다음 초기화 세팅을 하기 위해서
    private lateinit var  customAdapter: CustomAdapter
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        for(x in 0..30){
            businessCardArrayList.add(BusinessCard("록", "하이"))
            businessCardArrayList.add(BusinessCard("담", "하이"))
            businessCardArrayList.add(BusinessCard("록", "하이"))
            businessCardArrayList.add(BusinessCard("담", "하이"))

        }
        // 어뎁터를 arraylist로 추가해서 넘겨줌
        customAdapter = CustomAdapter(this, businessCardArrayList)
        // 리스트뷰에 어뎁터를 집어넣어 주면 끝!
        binding.listviewMain.adapter=customAdapter
    }
}