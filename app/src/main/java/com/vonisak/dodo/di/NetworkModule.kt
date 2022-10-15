package com.vonisak.dodo.di

import com.vonisak.dodo.data.network.PizzeriaApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    private companion object {

        const val BASE_URL = "https://6347dcb90484786c6e8ae6e1.mockapi.io/pizzapi/"
    }

    @Provides
    @PizzeriaBaseUrl
    fun provideBaseUrl(): String =
        BASE_URL

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        @PizzeriaBaseUrl baseUrl: String,
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .build()

    @Provides
    @Singleton
    fun provideRetrofitPizzeriaApi(retrofit: Retrofit): PizzeriaApi = retrofit.create(
        PizzeriaApi::class.java
    )

}