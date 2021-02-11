package com.mobbile.paul.bcmobiletrader.datasource

interface PreferenceStore {
    suspend fun clearPreferenceStorage()
}