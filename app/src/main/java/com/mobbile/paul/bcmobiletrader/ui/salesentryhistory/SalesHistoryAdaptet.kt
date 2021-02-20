package com.mobbile.paul.bcmobiletrader.ui.salesentryhistory

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobbile.paul.bcmobiletrader.R
import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductListEntity
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.sales_history_adaters.view.*


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
        fun bind(item: ProductListEntity) {
            containerView._tv_name.text = item.name
            containerView._tv_qty.text = item.qty.toString()
            containerView._tv_amount.text = ("%.2f".format(item.qty!!.toDouble() * item.amount!!.toDouble()))
            containerView._tv_unit.text = item.uofmeasure!!.substring(0,2)
            containerView._tv_shelf.text = item.shelf.toString()
        }
    }
}
