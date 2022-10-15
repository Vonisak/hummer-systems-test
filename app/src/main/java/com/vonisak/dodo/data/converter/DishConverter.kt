package com.vonisak.dodo.data.converter

import com.vonisak.dodo.data.model.DishNetwork
import com.vonisak.dodo.domain.entity.Dish

fun DishNetwork.toDish(): Dish = Dish(
    this.id,
    this.categoryId,
    this.name,
    this.price,
    this.description,
    this.image
)