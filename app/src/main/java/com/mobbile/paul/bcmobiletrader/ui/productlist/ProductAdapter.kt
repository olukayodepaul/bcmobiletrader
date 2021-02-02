package com.mobbile.paul.bcmobiletrader.ui.productlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobbile.paul.bcmobiletrader.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.product_adapter_layout.view.*


class ProductAdapter (private var mItems: List<ProductListEntity>, private val context: Context) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>(){


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        println("RECYCLERTEST $p1 $p0")
        val v = LayoutInflater.from(p0.context)
            .inflate(R.layout.product_adapter_layout, p0, false)
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
            containerView.tv_name_product.text = item.name
            containerView.setOnClickListener {

            }
        }
    }

}
