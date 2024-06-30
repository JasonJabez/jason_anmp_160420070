package com.example.jason_anmp_160420070.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jason_anmp_160420070.model.ModelDatabase
import com.example.jason_anmp_160420070.model.News
import com.example.jason_anmp_160420070.model.User
import com.example.jason_anmp_160420070.util.buildDb
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class UserDetailViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {
    val userLD = MutableLiveData<User?>()

    // 2way binding (login register)
    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val firstName = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()
    val email = MutableLiveData<String>()

    private var job = Job()

    override val coroutineContext: CoroutineContext get() = job + Dispatchers.IO

    fun fetchByID(id: Int){
        launch {
            val db = buildDb(getApplication())

            userLD.postValue(db.modelDao().fetchByID(id))
        }
    }

    fun fetchByCreds(){
        launch {
            val db = buildDb(getApplication())

            if(username.value != null && password.value != null){
                userLD.postValue(db.modelDao().fetchByCreds(username.value!!, password.value!!))
            }
        }
    }

    fun addUser(){
        launch{
            val db = buildDb(getApplication())

            if(username.value != null && password.value != null && email.value != null && lastName.value != null && firstName.value != null){
                val user = User(firstName=firstName.value!!, lastName=lastName.value!!, email=email.value!!,
                    username=username.value!!, password=password.value!!)
                db.modelDao().registerUser(user)
            }

        }
    }

    fun updateUser(firstName:String, lastName:String, password:String, userID:Int){
        launch{
            val db = buildDb(getApplication())

            db.modelDao().updateUser(firstName, lastName, password, userID)
        }
    }
}