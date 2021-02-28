package com.mobbile.paul.bcmobiletrader.ui.productlist

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.mobbile.paul.bcmobiletrader.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.product_adapter_layout.view.*
import kotlin.collections.ArrayList
import kotlin.reflect.KFunction2


class ProductAdapter(
    private val context: Context,
    private val clickListener: KFunction2<String, Int, Unit>
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() , Filterable {

    var  mItems: ArrayList<ProductListEntity>? = null
    var  filtermItems: ArrayList<ProductListEntity>? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context)
            .inflate(R.layout.product_adapter_layout, p0, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val item = mItems!![p1]
        p0.bind(item, clickListener)
    }

    override fun getItemCount(): Int {
        return mItems!!.size
    }

    fun ProductAdapter(searchResult: ArrayList<ProductListEntity>) {
        mItems = searchResult
        filtermItems = searchResult
    }

    inner class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        @SuppressLint("SetTextI18n")

        fun bind(
            item: ProductListEntity,
            clickListener: KFunction2<String, Int, Unit>
        ) {

            containerView.tv_name_product.text = item.name!!.toLowerCase().capitalize()
            containerView._id_check.isChecked = item.checkitem != 1
            containerView.itemid.text = item.groupname!!.capitalize()
            containerView.group_code.text =  item.item


            containerView._id_check.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    clickListener(item.item!!, 2)
                }else{
                    clickListener(item.item!!, 1)
                }
            }
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            @SuppressLint("DefaultLocale")
            override fun performFiltering(constraint: CharSequence?): FilterResults {

                val charString: String = constraint.toString().toLowerCase().trim()


                if(charString.isEmpty()){
                    mItems = filtermItems
                }else{

                    val filteredList = ArrayList<ProductListEntity>()

                    for (row in filtermItems!!) {
                        if(row.name!!.toLowerCase().contains(charString)){
                            filteredList.add(row)
                        }
                    }
                    mItems = filteredList
                }

                val filterResults = FilterResults()
                filterResults.values = mItems
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                mItems = results!!.values as ArrayList<ProductListEntity>?
                notifyDataSetChanged()
            }
        }
    }
}
