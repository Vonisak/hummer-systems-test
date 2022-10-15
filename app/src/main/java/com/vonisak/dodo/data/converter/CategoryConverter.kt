package com.vonisak.dodo.data.converter

import com.vonisak.dodo.data.model.CategoryNetwork
import com.vonisak.dodo.domain.entity.Category
import java.util.*

fun CategoryNetwork.toCategory(): Category = Category(
    this.id,
    this.name
)