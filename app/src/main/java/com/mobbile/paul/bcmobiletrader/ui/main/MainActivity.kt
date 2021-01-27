package com.mobbile.paul.bcmobiletrader.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobbile.paul.bcmobiletrader.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
    }

}

