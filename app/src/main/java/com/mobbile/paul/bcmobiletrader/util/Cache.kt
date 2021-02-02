package com.mobbile.paul.bcmobiletrader.util

import android.content.Context
import android.widget.Toast

class CacheError(context: Context, msg: String) {
    val toast = Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
}

