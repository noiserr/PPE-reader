package com.xdeveloper.ppereader

import android.app.Application
import com.xdeveloper.ppereader.di.DaggerRootComponent
import com.xdeveloper.ppereader.di.RootComponent

class PpeReaderApplication: Application() {

    val rootComponent: RootComponent by lazy {
        DaggerRootComponent.builder().build()
    }

}