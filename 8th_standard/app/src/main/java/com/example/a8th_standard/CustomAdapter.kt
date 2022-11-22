package com.example.a8th_standard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import com.example.a8th_standard.databinding.ActivityMainBinding
import com.example.a8th_standard.databinding.ListviewItemBinding

class CustomAdapter(context: Context, private val businessCardArraylist: ArrayList<BusinessCard>, private val likesArrayList:  android.content.SharedPreferences): BaseAdapter() {

    // system에 있는 API를 호출해서 애플리케이션에서 쓸 수 있는, 앱과 OS 사이의 중재자 역할을 함
    private val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    lateinit var binding: ListviewItemBinding
    val editor = likesArrayList.edit()
    // arraylist의 size를 반환
    override fun getCount(): Int = businessCardArraylist.size

    // 위치 값에 따른 데이터를 반환
    override fun getItem(position: Int): Any = businessCardArraylist[position]

    // 포지션 값을 반환
    override fun getItemId(position: Int): Long = position.toLong()

    // Kotlin 컴파일러는 type을 추론해주므로, 함수 뒤에 =만 작성하더라도 return type을 자동으로 추론해줌
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        binding = ListviewItemBinding.inflate(inflater,p2,false)
        binding.nameListviewItem.text = businessCardArraylist[p0].name // 위치에 맞는 데이터를 세팅
        binding.contentsListviewItem.text = businessCardArraylist[p0].contents
        binding.memoLikes.setChecked(likesArrayList.getBoolean(p0.toString(),false))
        binding.memoLikes.setOnCheckedChangeListener { buttonView, isChecked ->
            editor.putBoolean(p0.toString(), isChecked)
            editor.apply()
        }
        return binding.root;
    }
}




