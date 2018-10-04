package com.xdeveloper.ppereader.di

import com.xdeveloper.ppereader.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetworkModule::class
])
interface RootComponent{
    fun inject(activity: MainActivity)
}

