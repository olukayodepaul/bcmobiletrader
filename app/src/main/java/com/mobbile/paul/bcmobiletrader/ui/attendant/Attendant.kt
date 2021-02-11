package com.mobbile.paul.bcmobiletrader.ui.attendant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobbile.paul.bcmobiletrader.R
import kotlinx.android.synthetic.main.activity_attendant.*

class Attendant : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendant)

        _attendant_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}