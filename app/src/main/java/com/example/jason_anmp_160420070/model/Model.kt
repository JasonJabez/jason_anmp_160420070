package com.example.jason_anmp_160420070.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    var id:Int? = null,
    @ColumnInfo(name="firstName")
    var firstName:String?,
    @ColumnInfo(name="lastName")
    var lastName:String?,
    @ColumnInfo(name="username")
    var username:String?,
    @ColumnInfo(name="email")
    var email:String?,
    @ColumnInfo(name="password")
    var password:String?
)

@Entity
data class News(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    var id:Int?,
    @ColumnInfo(name="title")
    var title:String?,
    @ColumnInfo(name="author")
    var author:String?,
    @ColumnInfo(name="summary")
    var summary:String?,
    @ColumnInfo(name="newsText")
    var newsText:String?,
    @ColumnInfo(name="newsPicDir")
    var newsPicDir:String?
)