package com.jetsadawwts.pokedexapplication.repository

import com.jetsadawwts.pokedexapplication.utils.Resource
import com.jetsadawwts.pokedexapplication.data.remote.PokemonApi
import com.jetsadawwts.pokedexapplication.data.remote.responses.Pokemon
import com.jetsadawwts.pokedexapplication.data.remote.responses.PokemonList
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(private val api: PokemonApi) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val reponse = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknow error occured.")
        }
        return Resource.Success(reponse)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val reponse = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An unknow error occured.")
        }
        return Resource.Success(reponse)
    }

}