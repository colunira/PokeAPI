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


    fun getPokemonNames(gen: Int, context: Context? = null): LiveData<List<String>> {
        return when (gen) {
            0 -> {
                val db = PokemonDatabase.getInstance(context!!)
                db.pokemonDao().getAllPokemons()
            }
            in 1..4 -> {
                val remote = Remote()
                remote.getGeneration(gen)
            }
            else -> MutableLiveData<List<String>>()
        }
    }

    fun getPokemons(pokemons: List<String>): LiveData<List<Pokemon>> {
        val remote = Remote()
        return remote.getPokemons(pokemons)
    }

    fun getPokemon(pokemonName: String): LiveData<Pokemon> {
        val remote = Remote()
        return remote.getPokemon(pokemonName)
    }
}