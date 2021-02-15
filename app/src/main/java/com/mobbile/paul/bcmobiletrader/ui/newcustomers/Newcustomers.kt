package com.mobbile.paul.bcmobiletrader.ui.newcustomers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobbile.paul.bcmobiletrader.R
import kotlinx.android.synthetic.main.activity_newcustomers.*


class Newcustomers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newcustomers)

        new_customer_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}