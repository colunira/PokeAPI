package com.example.pokeapi.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokeapi.data.PokemonDatabase
import com.example.pokeapi.data.Repository
import com.example.pokeapi.model.Generation
import com.example.pokeapi.model.Pokemon
import com.example.pokeapi.model.PokemonSpecies
import com.example.pokeapi.model.PokemonStat

class HomeViewModel : ViewModel() {

    private val repository = Repository.getInstance()

    fun getPokemonNames(gen: Int, context: Context? = null) = repository.getPokemonNames(gen, context)

    fun getPokemons(pokemons: List<String>) = repository.getPokemons(pokemons)

    var generationID: MutableLiveData<Int> = MutableLiveData()



    fun getGeneration(id: Int): LiveData<Generation> {
        return repository.getGeneration(id)
    }
    fun getPokemons(pokemons: MutableList<PokemonSpecies>): LiveData<List<Pokemon>> {
        return repository.getPokemons(pokemons)
    }
}
