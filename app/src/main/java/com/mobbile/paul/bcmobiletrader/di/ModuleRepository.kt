package com.mobbile.paul.bcmobiletrader.di

import com.mobbile.paul.bcmobiletrader.dao.AppDao
import com.mobbile.paul.bcmobiletrader.mappers.ModuleDtoMapper
import com.mobbile.paul.bcmobiletrader.network.RetrofitService
import com.mobbile.paul.bcmobiletrader.repository.module.ModuleRepositories
import com.mobbile.paul.bcmobiletrader.repository.module.ModuleRepositorysImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ModuleRepository {

    @Singleton
    @Provides
    fun provideModuleRepository(
        retrofitService: RetrofitService,
        moduleDtoMapper: ModuleDtoMapper,
        appdoa: AppDao
    ): ModuleRepositories {
        return ModuleRepositorysImpl(
            retrofitService,moduleDtoMapper,appdoa
        )
    }
}