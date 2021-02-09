package com.mobbile.paul.bcmobiletrader.ui.customers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator
import com.mobbile.paul.bcmobiletrader.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.customeradapter.view.*
import kotlinx.android.synthetic.main.moduleadater_layout.view.*
import kotlinx.android.synthetic.main.moduleadater_layout.view._id_check
import kotlinx.android.synthetic.main.moduleadater_layout.view._tv_name_sales_entry
import kotlinx.android.synthetic.main.moduleadater_layout.view.icons_images
import kotlin.reflect.KFunction2


class CustomersAdapter(
    private var mItems: List<CustomersListDto>,
    private val context: Context,
    private val clickListener: KFunction2<CustomersListDto, String, Unit>
)
 :
    RecyclerView.Adapter<CustomersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context)
            .inflate(R.layout.customeradapter, p0, false)
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
            item: CustomersListDto,
            clickListener: KFunction2<CustomersListDto, String, Unit>) {
            val letter: String? = item.custname!!.substring(0, 1)
            val generator = ColorGenerator.MATERIAL
            val drawable = TextDrawable.builder()
                .buildRound(letter, generator.getRandomColor())
            containerView._id_check.setImageDrawable(drawable)
            containerView._tv_name_sales_entry.text = item.custname
            containerView.left_edcode.text = item.custno

            containerView.icons_images.setOnClickListener {
                showPopup(containerView, item, clickListener)
            }
        }
    }

    private fun showPopup(
        view: View,
        item: CustomersListDto,
        clickItems: KFunction2<CustomersListDto, String, Unit>
    )

    {
        val popupMenu = PopupMenu(context, view.icons_images)
        val inflater = popupMenu.menuInflater
        inflater.inflate(R.menu.floatingcontextmenu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id._id_outletOpen -> {
                    clickItems(item, "_id_outletOpen")
                }
                R.id._id_close_outlet->{
                    clickItems(item, "_id_close_outlet")
                }
                R.id._gps_location->{
                    clickItems(item, "_gps_location")
                }
                R.id._outlet_info_update->{
                    clickItems(item, "_outlet_info_update")
                }
                R.id.sales_entry_details->{
                    clickItems(item, "sales_entry_details")
                }
            }
            true
        }
        popupMenu.show()
    }
}
