package com.vonisak.dodo.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.vonisak.dodo.databinding.BannerItemBinding
import com.vonisak.dodo.domain.entity.Banner
import com.vonisak.dodo.ui.adapter.GlideAdapter

class BannerViewHolder(view: View, private val glideAdapter: GlideAdapter) :
    RecyclerView.ViewHolder(view) {
    private val binding = BannerItemBinding.bind(view)


    fun bind(banner: Banner, onBannerClick: (bannerId: Int) -> Unit) = with(binding) {

        glideAdapter.loadImage(banner.image, image)
        image.setOnClickListener {
            onBannerClick(banner.id)
        }
    }
}