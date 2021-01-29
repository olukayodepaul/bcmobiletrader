package com.mobbile.paul.bcmobiletrader.ui.mainloginfragment.repository

import com.mobbile.paul.bcmobiletrader.ui.mainloginfragment.UserLogin


interface LoginRepository {
    suspend fun login(username: String, password: String, imie: String): UserLogin
}