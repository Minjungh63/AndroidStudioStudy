package com.example.a8th_standard

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity // Room DB에서 사용되는 객체임을 알려줌
data class Memo(
    @ColumnInfo(name = "title") val title:String,
    @ColumnInfo(name="contents") val contents: String,
    // auto increment가 여기선 autoGenerate
    @PrimaryKey(autoGenerate= true) @ColumnInfo(name = "memoId") val memoId:Int = 0 // 기본값을 0으로 설정
)