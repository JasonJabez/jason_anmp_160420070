package com.example.jason_anmp_160420070.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jason_anmp_160420070.model.Car
import com.example.jason_anmp_160420070.model.Student
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CarViewModel(application: Application) : AndroidViewModel(application){
    val carsLD = MutableLiveData<ArrayList<Car>>()
    val carLoadErrorLD = MutableLiveData<Boolean>()
    val carloadLD = MutableLiveData<Boolean>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {
        carloadLD.value = true
        carLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/cars/cars.json"
        val stringRequest = StringRequest(
            Request.Method.GET, url, {
                val cType = object : TypeToken<List<Car>>() { }.type
                val result = Gson().fromJson<List<Car>>(it,cType)
                carsLD.value = result as ArrayList<Car>?
            },
            {
                Log.d("VolleyError", it.toString())
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)


        carLoadErrorLD.value = false
        carloadLD.value = false
    }
}