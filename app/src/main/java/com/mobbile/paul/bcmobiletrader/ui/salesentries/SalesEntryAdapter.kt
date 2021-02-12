package com.mobbile.paul.bcmobiletrader.ui.salesentries

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobbile.paul.bcmobiletrader.R
import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductListEntity
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.sales_entry_adapter.view.*
import kotlin.reflect.KFunction2


class SalesEntryAdapter(
    private var mItems: List<ProductListEntity>,
    private val context: Context,
    val clickListener: KFunction2<ProductListEntity, View?, Unit>
) :
    RecyclerView.Adapter<SalesEntryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context)
            .inflate(R.layout.sales_entry_adapter, p0, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val item = mItems[p1]
        p0.bind(item, clickListener)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bind(
            item: ProductListEntity,
            clickListener: KFunction2<ProductListEntity, View?, Unit>
        ) {
            containerView.en_text_content.text = item.name

            containerView._backroom.addTextChangedListener(
                object : TextWatcher {
                    override fun afterTextChanged(s: Editable?) {}
                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                        clickListener(item,containerView)
                    }
                }
            )

            containerView._shelf.addTextChangedListener(
                object : TextWatcher {
                    override fun afterTextChanged(s: Editable?) {}
                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                        clickListener(item,containerView)
                    }
                }
            )

            containerView._order.addTextChangedListener(
                object : TextWatcher {
                    override fun afterTextChanged(s: Editable?) {}
                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                        clickListener(item,containerView)
                        //(this@EntriesAdapter.clickListener)(item,containerView)
                    }
                }
            )
        }
    }
}
