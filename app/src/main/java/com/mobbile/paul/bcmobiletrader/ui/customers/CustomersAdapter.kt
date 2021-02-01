package com.mobbile.paul.bcmobiletrader.ui.customers

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator
import com.mobbile.paul.bcmobiletrader.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.moduleadater_layout.view.*


class CustomersAdapter (private var mItems: List<CustomersListDto>, private val context: Context) :
    RecyclerView.Adapter<CustomersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context)
            .inflate(R.layout.customeradapter, p0, false)
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
        fun bind(item: CustomersListDto) {

            val letter: String? = item.busines!!.substring(0, 1)
            val generator = ColorGenerator.MATERIAL
            val drawable = TextDrawable.builder()
                .buildRound(letter, generator.getRandomColor())
            containerView.imageView.setImageDrawable(drawable)
            containerView.tv_name.text = item.busines

            containerView.setOnClickListener {
                val intent = Intent(context, CustomersActivity::class.java)
                context.startActivity(intent)
            }
        }
    }
}
