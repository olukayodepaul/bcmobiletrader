package com.mobbile.paul.bcmobiletrader.di.module

import com.google.gson.GsonBuilder
import com.mobbile.paul.bcmobiletrader.mappers.ModuleDtoMapper
import com.mobbile.paul.bcmobiletrader.network.RetrofitService
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
    fun provideRecipeMapper(): ModuleDtoMapper {
        return ModuleDtoMapper()
    }

    @Singleton
    @Provides
    fun provideRecipeService(): RetrofitService {
        return Retrofit.Builder()
            .baseUrl("https://food2fork.ca/api/recipe/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(RetrofitService::class.java)
    }

}