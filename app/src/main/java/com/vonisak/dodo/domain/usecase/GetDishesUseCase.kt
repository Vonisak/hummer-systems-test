package com.vonisak.dodo.domain.usecase

import com.vonisak.dodo.domain.entity.Dish
import com.vonisak.dodo.domain.repository.PizzeriaRepository
import javax.inject.Inject

class GetDishesUseCase @Inject constructor(private val repository: PizzeriaRepository) {

    suspend operator fun invoke(id: Int): List<Dish> = repository.getDishes(id)
}