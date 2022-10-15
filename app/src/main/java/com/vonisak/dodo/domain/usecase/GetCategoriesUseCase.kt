package com.vonisak.dodo.domain.usecase

import com.vonisak.dodo.domain.entity.Category
import com.vonisak.dodo.domain.repository.PizzeriaRepository
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(private val repository: PizzeriaRepository) {

    suspend operator fun invoke(): List<Category> = repository.getCategories()
}