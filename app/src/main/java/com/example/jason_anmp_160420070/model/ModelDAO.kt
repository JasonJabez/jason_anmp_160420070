package com.example.jason_anmp_160420070.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ModelDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg user:User)

    @Query("SELECT * FROM user")
    fun selectAllUser(): List<User>

}