package com.vonisak.dodo.domain.usecase

import com.vonisak.dodo.domain.entity.Banner
import com.vonisak.dodo.domain.repository.PizzeriaRepository
import javax.inject.Inject

class GetBannersUseCase @Inject constructor(private val repository: PizzeriaRepository) {

    suspend operator fun invoke(): List<Banner> = repository.getBanners()
}