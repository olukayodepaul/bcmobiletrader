package com.mobbile.paul.bcmobiletrader.ui.mainlogin.repository

import android.content.SharedPreferences
import com.mobbile.paul.bcmobiletrader.datasource.AppDao
import com.mobbile.paul.bcmobiletrader.datasource.RetrofitService
import com.mobbile.paul.bcmobiletrader.ui.mainlogin.UserLoginRes


class LoginRepositoryImpl(
    private val retrofitService: RetrofitService,
    private val appdoa: AppDao,
    private val sharedPrefsEditor: SharedPreferences.Editor
) :
   LoginRepository{
    override suspend fun login(username: String, password: String, imie: String): UserLoginRes {
        return retrofitService.login(username, password, imie)
    }

    override suspend fun sharedPrefsEditor(): SharedPreferences.Editor {
        return sharedPrefsEditor
    }
}