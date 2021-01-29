package com.mobbile.paul.bcmobiletrader.ui.modulefragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator
import com.mobbile.paul.bcmobiletrader.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.moduleadater_layout.view.*

/*
class ModuleAdapter (private var mItems: List<DomainDataDto>) :
    RecyclerView.Adapter<ModuleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        println("RECYCLERTEST $p1 $p0")
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
        fun bind(item: DomainDataDto) {

            val letter: String? = item.title!!.substring(0, 1)
            val generator = ColorGenerator.MATERIAL
            val drawable = TextDrawable.builder()
                .buildRound(letter, generator.getRandomColor())
            containerView.imageView.setImageDrawable(drawable)
            containerView.tv_name.text = item.publisher

            containerView.setOnClickListener {
                it.findNavController().navigate(R.id.sentToSecondFragment);
            }
        }
    }

}*/
