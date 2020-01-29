package com.example.pokeapi.data

import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.example.pokeapi.MainActivity
import com.example.pokeapi.model.Generation
import com.example.pokeapi.model.Pokemon
import com.example.pokeapi.model.PokemonSpecies

class Repository {

    // Singleton
    companion object {
        private var instance: Repository? = null
        fun getInstance(): Repository {
            if(instance==null)
                instance = Repository()
            return instance as Repository
        }
    }

    val remote = Remote()

    fun getPokemonNames(gen: Int, context: Context? = null): LiveData<List<String>> {
        return when (gen) {
            0 -> {
                val db = PokemonDatabase.getInstance(context!!)
                db.pokemonDao().getAllPokemons()
            }
            in 1..4 -> {
                remote.getGeneration(gen)
            }
            else -> MutableLiveData<List<String>>()
        }
    }

    fun getPokemons(pokemons: List<String>, context: Context) = remote.getPokemons(pokemons, context)
}