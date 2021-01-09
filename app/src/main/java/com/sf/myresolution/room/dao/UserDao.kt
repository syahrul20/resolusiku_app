package com.sf.myresolution.room.dao

import androidx.room.*
import com.sf.myresolution.room.entity.User

/**
 * بِسْمِ اللهِ الرَّحْمٰنِ الرَّحِيْمِ
 * Created By Fahmi on 10/01/21
 */

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Query("SELECT * From tb_user")
    fun loadUser(): Array<User>

    @Query("DELETE FROM tb_user WHERE tb_user.id = :userId")
    fun deleteUser(userId: Int)
}
