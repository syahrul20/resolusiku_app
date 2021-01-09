package com.sf.myresolution.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * بِسْمِ اللهِ الرَّحْمٰنِ الرَّحِيْمِ
 * Created By Fahmi on 10/01/21
 */

@Entity(tableName = "tb_user")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val firstName: String?
)
