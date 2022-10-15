package com.vonisak.dodo.domain.repository

import com.vonisak.dodo.domain.entity.Banner
import com.vonisak.dodo.domain.entity.Category
import com.vonisak.dodo.domain.entity.Dish

interface PizzeriaRepository {

    suspend fun getCategories() : List<Category>

    suspend fun getDishes(id: Int): List<Dish>

    suspend fun getBanners(): List<Banner>
}