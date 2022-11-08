package com.example.a6th_standard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a6th_standard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(viewBinding.containerFragment.id, Fragment2())
            .commitAllowingStateLoss()
        //run를 쓰면 연결된 요소에 코드를 바로 작성할 수 있음
        viewBinding.navBottom.run{
            // it에 어떤 item을 눌렀는지 반영됨
            setOnItemSelectedListener {
                // when문으로 item의 id에 따라 어떤 동작을 할지 작성
                when(it.itemId){
                    R.id.menu_home ->{
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, Fragment1())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_setting -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, Fragment2())
                            .commitAllowingStateLoss()
                    }
                }
                // 리턴값을 true와 false로 받음. 일반적으로는 true로 바로 변경되도록 하면 됨
                true
            }
            // 함수지만 변수처럼 쓸 수 있음. 현재 선택한 item을 알려줄 수 있음
            selectedItemId = R.id.menu_home
        }
    }
}