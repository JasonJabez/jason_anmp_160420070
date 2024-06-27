package com.example.jason_anmp_160420070.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ModelDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun registerUser(vararg user:User)

    @Query("SELECT * FROM user WHERE id = :id")
    fun fetchByID(id:Int): User

    @Query("SELECT * FROM user WHERE username= :username AND password= :password")
    fun fetchByCreds(username:String, password:String): User

    @Query("UPDATE user SET firstName = :firstName, lastName = :lastName, password = :password WHERE id = :userID")
    fun updateUser(firstName:String, lastName:String, password:String, userID:Int)

    @Query("SELECT * FROM news")
    fun fetchNews(): List<News>

    @Query("SELECT * FROM news WHERE id = :id")
    fun fetchNewsByID(id:Int): News
}