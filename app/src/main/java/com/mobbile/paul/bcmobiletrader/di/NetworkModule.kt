package com.mobbile.paul.bcmobiletrader.di

import com.google.gson.GsonBuilder
import com.mobbile.paul.bcmobiletrader.datasource.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {



    @Singleton
    @Provides
    fun provideRecipeService(): RetrofitService {

        return Retrofit.Builder()
            .baseUrl("http://mtnodejsapi.com:9000/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(RetrofitService::class.java)
    }
}