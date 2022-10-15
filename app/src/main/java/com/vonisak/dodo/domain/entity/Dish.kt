package com.vonisak.dodo.domain.entity

data class Dish(
    val id: Int,
    val categoryId: Int,
    val name: String,
    val price: String,
    val description: String,
    val image: String
)