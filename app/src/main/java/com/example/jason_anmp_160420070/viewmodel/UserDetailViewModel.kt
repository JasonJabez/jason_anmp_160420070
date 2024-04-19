package com.example.jason_anmp_160420070.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jason_anmp_160420070.model.News
import com.example.jason_anmp_160420070.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class UserDetailViewModel(application: Application) : AndroidViewModel(application){
    val userLD = MutableLiveData<User>()
    val userLoadErrorLD = MutableLiveData<Boolean>()
    val userLoadLD = MutableLiveData<Boolean>()

    fun fetch(username:String, password:String){
        userLoadErrorLD.value = true
        userLoadLD.value = true

        userLD.value = User(1, "James", "Cameron", "jamescameron", "email", "password")

        userLoadErrorLD.value = false
        userLoadLD.value = false
    }

    fun fetch(userId: Int){
        userLoadErrorLD.value = true
        userLoadLD.value = true

        userLD.value = User(1, "James", "Cameron", "jamescameron", "email", "password")

        userLoadErrorLD.value = false
        userLoadLD.value = false
    }
}