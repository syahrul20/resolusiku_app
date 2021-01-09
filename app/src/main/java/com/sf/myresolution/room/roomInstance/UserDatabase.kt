package com.sf.myresolution.room.roomInstance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sf.myresolution.MainActivity
import com.sf.myresolution.constant.AppProvider
import com.sf.myresolution.room.dao.UserDao
import com.sf.myresolution.room.entity.User

/**
 * بِسْمِ اللهِ الرَّحْمٰنِ الرَّحِيْمِ
 * Created By Fahmi on 10/01/21
 */

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    UserDatabase::class.java,
                    AppProvider.DATABASE_NAME
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}