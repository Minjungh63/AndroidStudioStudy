package com.example.a8th_standard

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.a8th_standard.databinding.ActivityMainBinding
import com.example.a8th_standard.databinding.ListviewItemBinding

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

        val likesArrayList = getSharedPreferences("likesArrayList", Context.MODE_PRIVATE)

        val editor = likesArrayList.edit()
        val roomDb = AppDatabase.getInstance(this)

            if(roomDb != null) {
                val memoList = roomDb.MemoDao().selectAll()
                val memoLength = memoList.size
                for (x in 0 until memoLength) {
                    businessCardArrayList.add(BusinessCard(memoList[x].title, memoList[x].contents))

                    val memoLike = likesArrayList.getBoolean(memoList[x].memoId.toString(),false)
                    if(!memoLike) // 즐겨찾기 초기값 생성
                        editor.putBoolean(memoList[x].memoId.toString(), false) //put으로 삽입
                    editor.apply()
                }
            }
        // 메모 작성 페이지로 이동
        binding.floatingMemo.setOnClickListener(){
            val intent = Intent(this, WriteMemoActivity::class.java)
            startActivity(intent)
        }
        // 어뎁터를 arraylist로 추가해서 넘겨줌
        customAdapter = CustomAdapter(this, businessCardArrayList, likesArrayList)
        // 리스트뷰에 어뎁터를 집어넣어 주면 끝!
        binding.listviewMain.adapter=customAdapter
    }
}