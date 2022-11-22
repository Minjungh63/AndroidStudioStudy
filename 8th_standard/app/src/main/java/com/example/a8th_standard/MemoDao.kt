package com.example.a8th_standard

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao // 이렇게 작성하면, 함수들을 호출해서 사용할 수 있다.
interface MemoDao {
    @Insert
    fun insert(memo: Memo)

    @Delete
    fun delete(memo: Memo)

    // 직접 Query문을 사용할 때 @Query 붙임
    // SELECT 문 -> query 결과가 나오므로 return 타입을 작성해줘야 함
    @Query("SELECT * FROM Memo")
    fun selectAll() : List<Memo> // 여러개의 result가 나올 수 있으므로, List<User객체>로 작성해주기


    @Query("SELECT * FROM Memo WHERE memoId = :userId") //:userId를 쓰면 밑의 function param의 userId값이 :userID 자리로 들어감
    fun selectByMemoId(userId: Int) : Memo

    @Query("SELECT * FROM Memo WHERE title = :title and contents = :contents")
    fun selectByMemoTitleAndContents(title:String, contents:String) : List<Memo>

    @Query("UPDATE Memo SET title=:title WHERE memoId = :memoId")
    fun updateTitleByMemoId(memoId:Int, title:String)
}