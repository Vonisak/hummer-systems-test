package com.vonisak.dodo.data.model

import com.google.gson.annotations.SerializedName

data class BannerNetwork(
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: String
)
