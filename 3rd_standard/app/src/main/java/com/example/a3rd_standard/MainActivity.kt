package com.example.a3rd_standard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a3rd_standard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.button.setOnClickListener(){
            val intent = Intent(this, FirstActivity::class.java)
            intent.putExtra("text", viewBinding.editText.text.toString())
            startActivity(intent)
        }
    }
}