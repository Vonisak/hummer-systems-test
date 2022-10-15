package com.vonisak.dodo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vonisak.dodo.R
import com.vonisak.dodo.domain.entity.Dish
import com.vonisak.dodo.ui.viewholder.DishViewHolder

class DishAdapter(private val glideAdapter: GlideAdapter) : RecyclerView.Adapter<DishViewHolder>() {

    var dishes: List<Dish> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dish_item, parent, false)
        return DishViewHolder(view, glideAdapter)
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        holder.bind(dishes[position])
    }

    override fun getItemCount(): Int = dishes.size
}