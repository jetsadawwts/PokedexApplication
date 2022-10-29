package com.jetsadawwts.pokedexapplication.pokemondetail

import androidx.lifecycle.ViewModel
import com.jetsadawwts.pokedexapplication.data.remote.responses.Pokemon
import com.jetsadawwts.pokedexapplication.repository.PokemonRepository
import com.jetsadawwts.pokedexapplication.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
       return repository.getPokemonInfo(pokemonName)
    }

}