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
import com.example.jason_anmp_160420070.model.News
import com.example.jason_anmp_160420070.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class NewsListViewModel(application: Application) : AndroidViewModel(application) {
    val newsLD = MutableLiveData<ArrayList<News>>()
    val newsSingularLD = MutableLiveData<News>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    //gets all news
    fun refresh() {
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/160420070_anmp_uts/news.php"
        val stringRequest = StringRequest(
            Request.Method.GET, url, {
                val cType = object : TypeToken<List<News>>() { }.type
                val result = Gson().fromJson<List<News>>(it,cType)

                newsLD.value = result as ArrayList<News>
            },
            {
                Log.d("VolleyError", it.toString())
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    //gets specific news with ID
    fun fetch(newsId: Int){
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/160420070_anmp_uts/news.php?searchID=$newsId"
        val stringRequest = StringRequest(
            Request.Method.GET, url, {
                val cType = object : TypeToken<List<News>>() { }.type
                val result = Gson().fromJson<List<News>>(it,cType)

                newsSingularLD.value = result[0]
                Log.d("text", result.toString())
            },
            {
                Log.d("VolleyError", it.toString())
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}