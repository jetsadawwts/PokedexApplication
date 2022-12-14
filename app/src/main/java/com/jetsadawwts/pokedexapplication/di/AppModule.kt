package com.jetsadawwts.pokedexapplication.di

import com.jetsadawwts.pokedexapplication.data.remote.PokemonApi
import com.jetsadawwts.pokedexapplication.repository.PokemonRepository
import com.jetsadawwts.pokedexapplication.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object AppModule {

    @Singleton
    @Provides
    fun providePokemonRepository(api: PokemonApi) = PokemonRepository(api)

    @Singleton
    @Provides
    fun providePokemonApi(): PokemonApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokemonApi::class.java)
    }

}