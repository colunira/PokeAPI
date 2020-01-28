package com.example.pokeapi.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.pokeapi.data.Repository
import com.example.pokeapi.model.Generation
import com.example.pokeapi.model.Pokemon
import com.example.pokeapi.model.PokemonSpecies
import com.example.pokeapi.model.PokemonStat

class HomeViewModel : ViewModel() {
    val repository = Repository.getInstance()

    fun getGeneration(): LiveData<Generation> {
        return repository.getGeneration(1)
    }
    fun getPokemons(pokemons: MutableList<PokemonSpecies>): LiveData<List<Pokemon>> {
        return repository.getPokemons(pokemons)
    }
}