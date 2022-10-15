package com.vonisak.dodo.di

import com.vonisak.dodo.data.repository.PizzeriaRepositoryImpl
import com.vonisak.dodo.domain.repository.PizzeriaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface BindModule {

    @Binds
    fun bindAnimeRepository(impl: PizzeriaRepositoryImpl): PizzeriaRepository

}