package com.mobbile.paul.bcmobiletrader.ui.rejection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobbile.paul.bcmobiletrader.R
import kotlinx.android.synthetic.main.activity_sku_rejected.*

class SkuRejectedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sku_rejected)

        _rejection_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}