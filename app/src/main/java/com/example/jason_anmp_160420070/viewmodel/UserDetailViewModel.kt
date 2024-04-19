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
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    //gets user with username and pass (login)
    fun fetch(username:String, password:String){
        queue = Volley.newRequestQueue(getApplication())
        val url =
            "http://10.0.2.2/160420070_anmp_uts/user.php?action=login&username=$username&password=$password"
        val stringRequest = StringRequest(
            Request.Method.GET, url, {
                val cType = object : TypeToken<List<User>>() { }.type
                val result = Gson().fromJson<List<User>>(it,cType)

                if(result.isNotEmpty()) {
                    userLD.value = result[0]
                }
            },
            {
                Log.d("VolleyError", it.toString())
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    //gets user with ID
    fun fetch(userId: Int){
        queue = Volley.newRequestQueue(getApplication())
        val url =
            "http://10.0.2.2/160420070_anmp_uts/user.php?action=searchByID&userID=$userId"
        val stringRequest = StringRequest(
            Request.Method.GET, url, {
                val cType = object : TypeToken<List<User>>() { }.type
                val result = Gson().fromJson<List<User>>(it,cType)

                userLD.value = result[0]
            },
            {
                Log.d("VolleyError", it.toString())
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    //register
    fun registerUser(firstName: String, lastName: String, username: String, email: String, password: String){
        queue = Volley.newRequestQueue(getApplication())
        val url =
            "http://10.0.2.2/160420070_anmp_uts/user.php?action=register&firstName=$firstName&lastName=$lastName&username=$username&email=$email&password=$password"
        val stringRequest = StringRequest(
            Request.Method.GET, url, {
                val cType = object : TypeToken<List<User>>() { }.type
                val result = Gson().fromJson<List<User>>(it,cType)

                userLD.value = result[0]
            },
            {
                Log.d("VolleyError", it.toString())
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    fun updateUser(firstName: String, lastName: String, password: String, id: Int){
        queue = Volley.newRequestQueue(getApplication())
        val url =
            "http://10.0.2.2/160420070_anmp_uts/user.php?action=update&firstName=$firstName&lastName=$lastName&password=$password&userID=$id"
        val stringRequest = StringRequest(
            Request.Method.GET, url, {
                val cType = object : TypeToken<List<User>>() { }.type
                val result = Gson().fromJson<List<User>>(it,cType)

                userLD.value = result[0]
            },
            {
                Log.d("VolleyError", it.toString())
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}