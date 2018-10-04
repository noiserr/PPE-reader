package com.xdeveloper.ppereader.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.xdeveloper.ppereader.PpeService
import dagger.Module
import dagger.Provides
import pl.droidsonroids.retrofit2.JspoonConverterFactory
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesPpeService() : PpeService {
        return Retrofit.Builder()
                .baseUrl("https://www.ppe.pl/")
                .addConverterFactory(JspoonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
                .create(PpeService::class.java)
    }
}