package com.mobbile.paul.bcmobiletrader.ui.salesentryhistory

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobbile.paul.bcmobiletrader.R
import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductListEntity
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.sales_history_adaters.view.*
import java.text.NumberFormat


class SalesHistoryAdaptet (private var mItems: List<ProductListEntity>, private val context: Context) :
    RecyclerView.Adapter<SalesHistoryAdaptet.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context)
            .inflate(R.layout.sales_history_adaters, p0, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val item = mItems[p1]
        p0.bind(item)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        @SuppressLint("SetTextI18n")
        fun bind(item: ProductListEntity) {
            containerView.en_text_content.text = item.name
            containerView.tv_all_qty.text = "${item.qty.toString()}${item.uofmeasure!!.substring(0,3)}"
            containerView.tv_all_amount.text = NumberFormat.getInstance().format(item.qty!!.toDouble() * item.amount!!.toDouble())
            containerView.tv_shelf.text = item.shelf.toString()
        }
    }
}
