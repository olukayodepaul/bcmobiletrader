package com.mobbile.paul.bcmobiletrader.ui.mainlogin.repository

import com.mobbile.paul.bcmobiletrader.dao.AppDao
import com.mobbile.paul.bcmobiletrader.network.RetrofitService
import com.mobbile.paul.bcmobiletrader.ui.mainlogin.UserLoginRes


class LoginRepositoryImpl(
    private val retrofitService: RetrofitService,
    private val appdoa: AppDao
) :
   LoginRepository{
    override suspend fun login(username: String, password: String, imie: String): UserLoginRes {
        return retrofitService.login(username, password, imie)
    }
}