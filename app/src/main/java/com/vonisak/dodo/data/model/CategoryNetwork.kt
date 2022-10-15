package com.vonisak.dodo.data.model

import com.google.gson.annotations.SerializedName

data class CategoryNetwork(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)
