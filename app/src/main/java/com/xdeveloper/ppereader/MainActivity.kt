package com.xdeveloper.ppereader

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import pl.droidsonroids.jspoon.annotation.Selector
import pl.droidsonroids.retrofit2.JspoonConverterFactory
import retrofit2.Retrofit


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launch(UI) {
            val newsPage = createService().getNews().await()
            message.text = newsPage.news.joinToString(separator = "\n"){
                it.title ?: "elo"
            }

        }
    }


    private fun createService(): PpeService {
        return Retrofit.Builder()
                .baseUrl("https://www.ppe.pl/")
                .addConverterFactory(JspoonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
                .create(PpeService::class.java)
    }
}


