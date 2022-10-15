package com.vonisak.dodo.data.converter

import com.vonisak.dodo.data.model.BannerNetwork
import com.vonisak.dodo.domain.entity.Banner

fun BannerNetwork.toBanner(): Banner = Banner(
    this.id,
    this.image
)