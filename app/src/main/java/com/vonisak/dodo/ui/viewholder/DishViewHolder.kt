package com.vonisak.dodo.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.vonisak.dodo.databinding.DishItemBinding
import com.vonisak.dodo.domain.entity.Dish
import com.vonisak.dodo.ui.adapter.GlideAdapter

class DishViewHolder(view: View, private val glideAdapter: GlideAdapter) :
    RecyclerView.ViewHolder(view) {
    private val binding = DishItemBinding.bind(view)

    fun bind(dish: Dish) = with(binding) {

        glideAdapter.loadImage(dish.image, image)
        name.text = dish.name
        description.text = dish.description
        val priceFull = "от ${dish.price} р"
        price.text = priceFull
    }
}