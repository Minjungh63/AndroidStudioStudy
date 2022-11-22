package com.example.a8th_standard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a8th_standard.databinding.ActivityWriteMemoBinding

class WriteMemoActivity : AppCompatActivity() {
    lateinit var binding: ActivityWriteMemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteMemoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.memoButton.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            val roomDb = AppDatabase.getInstance(this)
            if(roomDb != null) {
                val memo = Memo(binding.titleInput.text.toString(), binding.memoContents.text.toString())
                roomDb.MemoDao().insert(memo)
            }
            startActivity(intent)
        }
    }
}