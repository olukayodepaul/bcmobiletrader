package com.mobbile.paul.bcmobiletrader.di

import com.mobbile.paul.bcmobiletrader.dao.AppDao
import com.mobbile.paul.bcmobiletrader.network.RetrofitService
import com.mobbile.paul.bcmobiletrader.ui.customers.repository.CustomerRepository
import com.mobbile.paul.bcmobiletrader.ui.customers.repository.CustomerRepositoryImpl
import com.mobbile.paul.bcmobiletrader.ui.modulefragment.repository.ModuleRepository
import com.mobbile.paul.bcmobiletrader.ui.modulefragment.repository.ModuleRepositoryImpl
import com.mobbile.paul.bcmobiletrader.ui.mainloginfragment.repository.LoginRepository
import com.mobbile.paul.bcmobiletrader.ui.mainloginfragment.repository.LoginRepositoryImpl
import com.mobbile.paul.bcmobiletrader.ui.productlist.repository.ProductListRepository
import com.mobbile.paul.bcmobiletrader.ui.productlist.repository.ProductListRepositoryImpl
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
        appdoa: AppDao
    ): LoginRepository {
        return LoginRepositoryImpl(
            retrofitService,appdoa
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
        appdoa: AppDao
    ): CustomerRepository {
        return CustomerRepositoryImpl(
            retrofitService, appdoa
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

}