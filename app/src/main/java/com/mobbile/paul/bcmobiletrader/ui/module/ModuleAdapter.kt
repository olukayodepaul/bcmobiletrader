package com.mobbile.paul.bcmobiletrader.ui.module

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
