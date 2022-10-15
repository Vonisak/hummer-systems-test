package com.vonisak.dodo.data.datasource

import com.vonisak.dodo.data.model.BannerNetwork
import com.vonisak.dodo.data.model.CategoryNetwork
import com.vonisak.dodo.data.model.DishNetwork
import com.vonisak.dodo.data.network.PizzeriaApi
import javax.inject.Inject

class PizzeriaDataSource @Inject constructor(private val api: PizzeriaApi) {

    suspend fun getCategories(): List<CategoryNetwork> = api.getCategories()

    suspend fun getDishes(categoryId: Int): List<DishNetwork> = api.getDishes(categoryId)

    suspend fun getBanners(): List<BannerNetwork> = api.getBanners()
}