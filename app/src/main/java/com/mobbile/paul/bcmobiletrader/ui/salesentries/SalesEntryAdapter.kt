package com.mobbile.paul.bcmobiletrader.ui.salesentries

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobbile.paul.bcmobiletrader.R
import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductListEntity
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.sales_entry_adapter.view.*


class SalesEntryAdapter(
    private var mItems: List<ProductListEntity>,
    private val context: Context
) :
    RecyclerView.Adapter<SalesEntryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context)
            .inflate(R.layout.sales_entry_adapter, p0, false)
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
            containerView._tv_name_sales_entry.text = item.name
        }
    }
}
