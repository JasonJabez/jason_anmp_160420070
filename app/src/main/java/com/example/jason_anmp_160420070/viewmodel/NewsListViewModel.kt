package com.example.jason_anmp_160420070.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

class NewsListViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {
    val newsLD = MutableLiveData<List<News>>()
    val newsSingularLD = MutableLiveData<News>()

    private var job = Job()

    override val coroutineContext: CoroutineContext get() = job + Dispatchers.IO

    fun fetchByID(id: Int){
        launch {
            val db = ModelDatabase.buildDatabase(
                getApplication()
            )

            newsSingularLD.postValue(db.modelDao().fetchNewsByID(id))
        }
    }

    fun fetch(){
        launch {
            val db = ModelDatabase.buildDatabase(
                getApplication()
            )

            newsLD.postValue(db.modelDao().fetchNews())
        }
    }
}