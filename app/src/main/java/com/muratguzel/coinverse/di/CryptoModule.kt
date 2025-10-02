package com.muratguzel.coinverse.di

import com.muratguzel.coinverse.data.remote.CryptoApi
import com.muratguzel.coinverse.data.repository.CryptoRepositoryImpl
import com.muratguzel.coinverse.domain.repository.CryptoRepository
import com.muratguzel.coinverse.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CryptoModule {

    @Singleton
    @Provides
    fun provideCryptoApi(): CryptoApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoApi::class.java)
    }
    @Singleton
    @Provides
    fun provideRepository(cryptoApi: CryptoApi): CryptoRepository{
        return CryptoRepositoryImpl(cryptoApi)
    }
}