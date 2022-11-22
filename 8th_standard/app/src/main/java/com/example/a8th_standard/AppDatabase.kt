package com.example.a8th_standard

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// abstract로 해주기 (공식문서를 따름)
// RoomDatabase를 상속
// 싱글톤 패턴: Database는 모든 앱에서 전역적으로 사용되므로, 하나의 앱에서 사용될 때 데이터베이스 객체를 계속 생성하지 않고 재활용
@Database(entities = [Memo::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun MemoDao(): MemoDao // 이렇게만 작성해줘도, UserDao와 연결하는 코드를 따로 작성하지 않아도, RoomDatabase를 상속받았으므로 바로 사용 가능

    // companion object: 전역적으로 사용할 수 있는 함수, 변수를 담을 수 있음
    companion object{
        // database 객체가 실제로 담기는 변수. 변수에 직접적으로 접근하면 안되므로, private로 선언하기
        private var appDatabase: AppDatabase? = null

        @Synchronized// 여러 thread에서 동시에 하나의 자원에 접근하려할 때, 이를 방지하기 위해 Synchronized 작성
        fun getInstance(context: Context): AppDatabase?{ // 데이터베이스 객체를 리턴받음
            // null 체크를 해줘야 함. null이면 database를 초기화해줘야 함.
           if(appDatabase == null){
               // 의미: 이 class가 점유를 하고 있음
               synchronized(AppDatabase::class.java){
                   appDatabase = Room.databaseBuilder(
                       context.applicationContext,
                       AppDatabase::class.java,
                       // Room DB를 여러개 만든다면, name은 겹치면 안됨
                       "app-database"
                   ).allowMainThreadQueries().build() // allowMainThreadQueries(): Main thread에서 query를 허용하는 함수
               }
            }
            return appDatabase
        }

    }

}