package com.example.pokeapi.ui.home

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokeapi.data.Repository

class HomeViewModel : ViewModel() {

    private val repository = Repository.getInstance()

    fun getPokemonNames(gen: Int, context: Context? = null) = repository.getPokemonNames(gen, context)

    fun getPokemons(pokemons: List<String>) = repository.getPokemons(pokemons)

    var generationID: MutableLiveData<Int> = MutableLiveData()

}
