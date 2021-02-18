package com.mobbile.paul.bcmobiletrader.ui.salesentryhistory


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobbile.paul.bcmobiletrader.R
import kotlinx.android.synthetic.main.activity_sales_entry_history.*


class SalesEntryHistory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sales_entry_history)

        _sales_history_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

}