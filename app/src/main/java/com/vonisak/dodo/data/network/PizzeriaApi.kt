package com.vonisak.dodo.data.network

import com.vonisak.dodo.data.model.BannerNetwork
import com.vonisak.dodo.data.model.CategoryNetwork
import com.vonisak.dodo.data.model.DishNetwork
import retrofit2.http.GET
import retrofit2.http.Path

interface PizzeriaApi {
    @GET("category")
    suspend fun getCategories() : List<CategoryNetwork>

    @GET("category/{id}/dish")
    suspend fun getDishes(
        @Path("id") id: Int
    ): List<DishNetwork>

    @GET("banner")
    suspend fun getBanners(): List<BannerNetwork>
}