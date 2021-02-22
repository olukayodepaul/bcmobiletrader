package com.mobbile.paul.bcmobiletrader.ui.outletupdate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobbile.paul.bcmobiletrader.R
import kotlinx.android.synthetic.main.activity_update_outlet.*


class UpdateOutletActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_outlet)

        update_customer_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}