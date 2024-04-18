package com.example.jason_anmp_160420070.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jason_anmp_160420070.model.News
import com.example.jason_anmp_160420070.model.User

class NewsListViewModel : ViewModel() {
    val newsLD = MutableLiveData<ArrayList<News>>()
    val newsSingularLD = MutableLiveData<News>()
    val newsLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun refresh() {
        newsLoadErrorLD.value = true
        loadingLD.value = true

        newsLD.value = arrayListOf(
            News(1,"Orange cat racism", "Not an Orange", "Orange cats face persecution..", "test1"),
            News(2,"Black cats are best!", "HOUND", "Black cats, often seen as a sign of bad luck..", "test2"),
            News(3,"The Male Calico", "Cat News Network", "Calicos are nearly all female. However,..", "test3")
        )

        newsLoadErrorLD.value = false
        loadingLD.value = false
    }

    fun fetch(newsId: Int){
        newsLoadErrorLD.value = true
        loadingLD.value = true

        newsSingularLD.value = News(1,"Orange cat racism", "Not an Orange", "Orange cats face persecution..", "test1")

        newsLoadErrorLD.value = false
        loadingLD.value = false
    }
}