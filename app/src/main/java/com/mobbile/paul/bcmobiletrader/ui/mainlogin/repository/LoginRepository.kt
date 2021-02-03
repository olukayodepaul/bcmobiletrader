package com.mobbile.paul.bcmobiletrader.ui.mainlogin.repository

import android.content.SharedPreferences
import com.mobbile.paul.bcmobiletrader.ui.mainlogin.UserLoginRes


interface LoginRepository {
    suspend fun login(username: String, password: String, imie: String): UserLoginRes
    suspend fun sharedPrefsEditor(): SharedPreferences.Editor
}