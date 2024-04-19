package com.example.jason_anmp_160420070.model

import com.google.gson.annotations.SerializedName

data class User(
    var id:Int?,
    var firstName:String?,
    var lastName:String?,
    var username:String?,
    var email:String?,
    var password:String?
)

data class News(
    var id:Int?,
    var title:String?,
    var author:String?,
    var summary:String?,
    var newsText:String?,
    var newsPicDir:String?
)