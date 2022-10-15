package com.vonisak.dodo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vonisak.dodo.R
import com.vonisak.dodo.domain.entity.Banner
import com.vonisak.dodo.ui.viewholder.BannerViewHolder

class BannerAdapter(
    private val glideAdapter: GlideAdapter,
    private val onBannerClick: (bannerId: Int) -> Unit
) : RecyclerView.Adapter<BannerViewHolder>() {

    var banners: List<Banner> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.banner_item, parent, false)
        return BannerViewHolder(view, glideAdapter)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(banners[position], onBannerClick)
    }

    override fun getItemCount(): Int = banners.size
}