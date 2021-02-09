package com.mobbile.paul.bcmobiletrader.di

import android.content.SharedPreferences
import com.mobbile.paul.bcmobiletrader.datasource.AppDao
import com.mobbile.paul.bcmobiletrader.datasource.RetrofitService
import com.mobbile.paul.bcmobiletrader.ui.customers.repository.CustomerRepository
import com.mobbile.paul.bcmobiletrader.ui.customers.repository.CustomerRepositoryImpl
import com.mobbile.paul.bcmobiletrader.ui.module.repository.ModuleRepository
import com.mobbile.paul.bcmobiletrader.ui.module.repository.ModuleRepositoryImpl
import com.mobbile.paul.bcmobiletrader.ui.mainlogin.repository.LoginRepository
import com.mobbile.paul.bcmobiletrader.ui.mainlogin.repository.LoginRepositoryImpl
import com.mobbile.paul.bcmobiletrader.ui.productlist.repository.ProductListRepository
import com.mobbile.paul.bcmobiletrader.ui.productlist.repository.ProductListRepositoryImpl
import com.mobbile.paul.bcmobiletrader.ui.salesentries.repository.SalesEntryRepository
import com.mobbile.paul.bcmobiletrader.ui.salesentries.repository.SalesEntryRepositoryImpl
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
    fun provideLoginRepository(
        retrofitService: RetrofitService,
        appdoa: AppDao,
        sharedPrefsEditor: SharedPreferences.Editor
    ): LoginRepository {
        return LoginRepositoryImpl(
            retrofitService,appdoa, sharedPrefsEditor
        )
    }

    @Singleton
    @Provides
    fun provideModuleRepository(
        retrofitService: RetrofitService,
        appdoa: AppDao
    ): ModuleRepository {
        return ModuleRepositoryImpl(
            retrofitService,  appdoa
        )
    }

    @Singleton
    @Provides
    fun provideCustomerRepository(
        retrofitService: RetrofitService,
        appdoa: AppDao,
        sharedPreferences: SharedPreferences
    ): CustomerRepository {
        return CustomerRepositoryImpl(
            retrofitService, appdoa, sharedPreferences
        )
    }

    @Singleton
    @Provides
    fun provideProductListepository(
        retrofitService: RetrofitService,
        appdoa: AppDao
    ): ProductListRepository {
        return ProductListRepositoryImpl(
            retrofitService, appdoa
        )
    }

    @Singleton
    @Provides
    fun provideSalesEntrypository(
        retrofitService: RetrofitService,
        appdoa: AppDao
    ): SalesEntryRepository {
        return SalesEntryRepositoryImpl(
            retrofitService, appdoa
        )
    }
}