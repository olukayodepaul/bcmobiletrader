package com.mobbile.paul.bcmobiletrader.di.module

import com.mobbile.paul.bcmobiletrader.mappers.ModuleDtoMapper
import com.mobbile.paul.bcmobiletrader.network.RetrofitService
import com.mobbile.paul.bcmobiletrader.repository.module.ModuleRepositories
import com.mobbile.paul.bcmobiletrader.repository.module.ModuleRepositoriesImpl
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
        moduleDtoMapper: ModuleDtoMapper
    ): ModuleRepositories {
        return ModuleRepositoriesImpl(
            retrofitService = retrofitService,
            moduleDtoMapper = moduleDtoMapper
        )
    }
}