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
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class UserDetailViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {
    val userLD = MutableLiveData<User?>()

    private var job = Job()

    override val coroutineContext: CoroutineContext get() = job + Dispatchers.IO

    fun fetchByID(id: Int){
        launch {
            val db = ModelDatabase.buildDatabase(
                getApplication()
            )

            userLD.postValue(db.modelDao().fetchByID(id))
        }
    }

    fun fetchByCreds(username: String, password: String){
        launch {
            val db = ModelDatabase.buildDatabase(
                getApplication()
            )

            userLD.postValue(db.modelDao().fetchByCreds(username, password))
        }
    }

    fun addUser(user:User){
        launch{
            val db = ModelDatabase.buildDatabase(
                getApplication()
            )

            db.modelDao().registerUser(user)
        }
    }

    fun updateUser(firstName:String, lastName:String, password:String, userID:Int){
        launch{
            val db = ModelDatabase.buildDatabase(
                getApplication()
            )

            db.modelDao().updateUser(firstName, lastName, password, userID)
        }
    }
}