package com.xdeveloper.ppereader

import kotlinx.coroutines.experimental.Deferred
import pl.droidsonroids.jspoon.annotation.Selector
import retrofit2.http.GET

interface PpeService {
    @GET("./")
    fun getNews(): Deferred<NewsPage>
}


class NewsPage {
    @Selector(".newsbox .box") lateinit var news: List<News>
}


class News {
    @Selector(".image_big > a", attr = "title") var title: String? = null
}

