package com.example.pokeapi.data

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
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

    // Data sources
    val remote = Remote()

    fun getGeneration(id: Int): MutableLiveData<Generation> {
        return remote.getGeneration(id)
//        val pokemons = MutableLiveData<List<Pokemon>>()
//        val pokemonsList = mutableListOf<Pokemon>()
//
//        for (pokemon in generation.value!!.pokemons) {
//            Log.v("POBIERAM", pokemon.name)
//            val p = remote.getPokemon(pokemon.name)
//            pokemonsList.add(p!!)
//        }

//        pokemons.value=pokemonsList
    }
    fun getPokemons(pokemons: MutableList<PokemonSpecies>): MutableLiveData<List<Pokemon>> {
        return remote.getPokemons(pokemons)
    }
}