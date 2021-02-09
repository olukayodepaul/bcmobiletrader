package com.mobbile.paul.bcmobiletrader.ui.module

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator
import com.mobbile.paul.bcmobiletrader.R
import com.mobbile.paul.bcmobiletrader.ui.attendant.Attendant
import com.mobbile.paul.bcmobiletrader.ui.customers.CustomersActivity
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.moduleadater_layout.view.*


class ModuleAdapter (private var mItems: List<ModulesListDto>,  private val context: Context) :
    RecyclerView.Adapter<ModuleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context)
            .inflate(R.layout.moduleadater_layout, p0, false)
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
        fun bind(item: ModulesListDto) {

            val letter: String? = item.name!!.substring(0, 1)
            val generator = ColorGenerator.MATERIAL
            val drawable = TextDrawable.builder()
                .buildRound(letter, generator.getRandomColor())
            containerView._id_check.setImageDrawable(drawable)
            containerView._tv_name_sales_entry.text = item.name

            containerView.setOnClickListener {
                when(item.navid){
                    1->{
                        val intent = Intent(context, Attendant::class.java)
                        context.startActivity(intent)
                    }
                    2->{
                        val intent = Intent(context, CustomersActivity::class.java)
                        context.startActivity(intent)
                    }
                }
            }
        }
    }
}
