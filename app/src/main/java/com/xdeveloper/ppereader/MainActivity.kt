package com.xdeveloper.ppereader

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xdeveloper.ppereader.di.RootComponent
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject lateinit var ppeService: PpeService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as PpeReaderApplication).rootComponent.inject(this)

        launch(UI) {
            val newsPage = ppeService.getNews().await()
            message.text = newsPage.news.joinToString(separator = "\n") {
                "${it.title?.take(10)} \n ${it.category} \n ${it.imageSrc}"
            }
        }
    }
}


