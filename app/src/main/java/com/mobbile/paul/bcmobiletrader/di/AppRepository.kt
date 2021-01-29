package com.mobbile.paul.bcmobiletrader.di

import com.mobbile.paul.bcmobiletrader.dao.AppDao
import com.mobbile.paul.bcmobiletrader.mappers.ModuleDtoMapper
import com.mobbile.paul.bcmobiletrader.network.RetrofitService
import com.mobbile.paul.bcmobiletrader.repository.customers.CustomerRepository
import com.mobbile.paul.bcmobiletrader.repository.customers.CustomerRepositorysImpl
import com.mobbile.paul.bcmobiletrader.repository.module.ModuleRepositories
import com.mobbile.paul.bcmobiletrader.repository.module.ModuleRepositorysImpl
import com.mobbile.paul.bcmobiletrader.ui.mainloginfragment.repository.LoginRepository
import com.mobbile.paul.bcmobiletrader.ui.mainloginfragment.repository.LoginRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppRepository {

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

    @Singleton
    @Provides
    fun provideCustomersRepository(
        retrofitService: RetrofitService,
        moduleDtoMapper: ModuleDtoMapper,
        appdoa: AppDao
    ): CustomerRepository {
        return CustomerRepositorysImpl(
            retrofitService,moduleDtoMapper,appdoa
        )
    }

    @Singleton
    @Provides
    fun provideLoginRepository(
        retrofitService: RetrofitService,
        moduleDtoMapper: ModuleDtoMapper,
        appdoa: AppDao
    ): LoginRepository {
        return LoginRepositoryImpl(
            retrofitService,moduleDtoMapper,appdoa
        )
    }

}