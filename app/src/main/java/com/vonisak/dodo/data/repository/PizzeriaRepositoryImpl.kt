package com.vonisak.dodo.data.repository

import com.vonisak.dodo.data.datasource.PizzeriaDataSource
import com.vonisak.dodo.domain.entity.Banner
import com.vonisak.dodo.domain.entity.Category
import com.vonisak.dodo.domain.entity.Dish
import com.vonisak.dodo.domain.repository.PizzeriaRepository
import com.vonisak.dodo.data.converter.toCategory
import com.vonisak.dodo.data.converter.toDish
import com.vonisak.dodo.data.converter.toBanner
import javax.inject.Inject

class PizzeriaRepositoryImpl @Inject constructor(private val dataSource: PizzeriaDataSource) :
    PizzeriaRepository {

    override suspend fun getCategories(): List<Category> =
        dataSource.getCategories().map { it.toCategory() }


    override suspend fun getDishes(id: Int): List<Dish> =
        dataSource.getDishes(id).map { it.toDish() }

    override suspend fun getBanners(): List<Banner> = dataSource.getBanners().map { it.toBanner() }
}