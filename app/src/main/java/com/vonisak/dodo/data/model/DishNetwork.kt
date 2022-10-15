package com.vonisak.dodo.data.model

import com.google.gson.annotations.SerializedName

data class DishNetwork(
    @SerializedName("id") val id: Int,
    @SerializedName("categoryId") val categoryId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("price") val price: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String
)