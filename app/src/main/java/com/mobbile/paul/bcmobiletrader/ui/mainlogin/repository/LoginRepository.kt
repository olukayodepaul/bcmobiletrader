package com.mobbile.paul.bcmobiletrader.ui.mainlogin.repository

import com.mobbile.paul.bcmobiletrader.ui.mainlogin.UserLoginRes


interface LoginRepository {
    suspend fun login(username: String, password: String, imie: String): UserLoginRes
}