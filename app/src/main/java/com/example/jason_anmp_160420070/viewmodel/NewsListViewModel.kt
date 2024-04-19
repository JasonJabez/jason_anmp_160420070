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
            News(1,"Orange cat racism", "Not an Orange", "Orange cats face persecution..", "test1", "https://cdn.britannica.com/70/234870-050-D4D024BB/Orange-colored-cat-yawns-displaying-teeth.jpg"),
            News(2,"Black cats are best!", "HOUND", "Black cats, often seen as a sign of bad luck..", "test2", "https://images.unsplash.com/photo-1503431128871-cd250803fa41?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8YmxhY2slMjBjYXR8ZW58MHx8MHx8fDA%3D"),
            News(3,"The Male Calico", "Cat News Network", "Calicos are nearly all female. However,..", "test3", "https://www.catster.com/wp-content/uploads/2018/03/Calico-cat.jpg")
        )

        newsLoadErrorLD.value = false
        loadingLD.value = false
    }

    fun fetch(newsId: Int){
        newsLoadErrorLD.value = true
        loadingLD.value = true

        newsSingularLD.value = News(1,"Orange cat racism", "Not an Orange", "Orange cats face persecution..",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed consectetur interdum diam, a rhoncus justo lobortis sed. Nulla nec turpis velit. Ut quis nulla vel libero sagittis fermentum quis ac purus. In in maximus augue. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Integer non pretium ante, non venenatis leo. Morbi vel sagittis diam. Duis ut nisi at nibh commodo mollis. Donec convallis volutpat maximus. Praesent sapien urna, tincidunt ut euismod quis, consequat eu nisl.\n" +
                "\n" +
                "Donec luctus a urna ac tristique. Morbi fermentum, massa sit amet hendrerit malesuada, nisl neque euismod odio, ut scelerisque urna odio at nulla. Pellentesque bibendum egestas tortor ac cursus. Morbi libero turpis, eleifend bibendum mattis non, pretium a dui. Cras venenatis tempor justo, in pellentesque ligula. Duis et vehicula turpis. Aenean non tortor ornare odio rhoncus finibus. Cras euismod metus eget tempor congue.\n" +
                "\n" +
                "Donec eget massa diam. Nam ornare mollis diam sed scelerisque. Suspendisse molestie in velit dictum malesuada. Praesent venenatis ipsum sapien, eget varius elit venenatis vel. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce mollis lacus bibendum turpis auctor consequat. Ut vel bibendum orci, ut mattis est. Mauris ullamcorper vestibulum nisi vel commodo. Quisque placerat venenatis dolor ullamcorper interdum. Duis elementum feugiat nisl, vitae commodo elit vehicula et. Sed fringilla dolor ex, sit amet interdum mauris viverra ac. Nulla consectetur cursus urna eu accumsan.\n" +
                "\n" +
                "Vivamus at erat nunc. Nunc erat arcu, lacinia eu neque ut, aliquet finibus velit. Cras venenatis nibh ac suscipit condimentum. Proin hendrerit odio in venenatis consectetur. Sed lacinia sollicitudin libero, maximus vehicula dui tincidunt quis. Etiam quis laoreet ligula, vitae egestas tellus. Vestibulum sem magna, malesuada sed vulputate et, efficitur eu dui. Donec et dui iaculis, tempus augue nec, semper ante. Vivamus sagittis tincidunt dui. Cras sit amet vulputate odio. Etiam quis feugiat orci. Donec lobortis lorem id quam ullamcorper pellentesque.\n" +
                "\n" +
                "Morbi eu lorem at urna placerat mattis. Donec ac nulla vitae nisi consectetur auctor quis ut velit. Integer rutrum rutrum mi, egestas malesuada nibh lacinia nec. Vivamus vitae mi in est iaculis tempus vel nec risus. Vivamus id euismod dolor. Suspendisse potenti. Nulla neque ante, ornare nec egestas accumsan, accumsan in nisl. Mauris a tellus id tellus tristique aliquam in ut felis. Integer suscipit ornare leo, quis auctor turpis posuere et. Vivamus nec eros in velit ornare faucibus. Curabitur ut nunc nisi. Fusce mattis tincidunt lacus at pretium. Fusce ut tincidunt massa. Nullam egestas velit finibus quam faucibus, quis interdum tellus scelerisque. Maecenas in felis id massa faucibus scelerisque. ",
            "https://cdn.britannica.com/70/234870-050-D4D024BB/Orange-colored-cat-yawns-displaying-teeth.jpg"
            )

        newsLoadErrorLD.value = false
        loadingLD.value = false
    }
}