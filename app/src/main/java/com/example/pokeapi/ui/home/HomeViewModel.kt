package com.example.pokeapi.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokeapi.model.Pokemon

class HomeViewModel : ViewModel() {


    fun loadPokemons(): LiveData<List<Pokemon>> {
        val pokemons = MutableLiveData<List<Pokemon>>()
        pokemons.value= listOf(Pokemon(), Pokemon())
        return pokemons
    }
}