package com.example.pokeapi.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.pokeapi.model.Generation
import com.example.pokeapi.model.Pokemon
import com.example.pokeapi.model.PokemonSpecies
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Remote {
    val retrofit = Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create())).build()
    val pokeService = retrofit.create(PokeAPI::class.java)

    fun getGeneration(id: Int): MutableLiveData<Generation> {
        val generation: MutableLiveData<Generation> = MutableLiveData()
        val call = pokeService.getGeneration(id)
        call.enqueue(object : Callback<Generation> {
            override fun onFailure(call: Call<Generation>, t: Throwable) {
            }
            override fun onResponse(
                call: Call<Generation>,
                response: Response<Generation>
            ) {
                generation.value = response.body()
            }
        })

        return generation
    }

    fun getPokemon(name: String): MutableLiveData<Pokemon> {
        var pokemon: MutableLiveData<Pokemon> = MutableLiveData()
        val call = pokeService.getPokemonByName(name)
        call.enqueue(object : Callback<Pokemon> {
            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                Log.v("PokeAPI ERROR", t.toString())
            }
            override fun onResponse(
                call: Call<Pokemon>,
                response: Response<Pokemon>
            ) {
                pokemon.value = response.body()
                Log.v("DUPA", pokemon.value!!.name)
            }
        })

        return pokemon
    }
    fun getPokemons(pokemons: MutableList<PokemonSpecies>): MutableLiveData<List<Pokemon>> {
        var pokemon: MutableLiveData<List<Pokemon>> = MutableLiveData()
        var list: MutableList<Pokemon> = mutableListOf()
        for (p in pokemons) {
            val call = pokeService.getPokemonByName(p.name)
            call.enqueue(object : Callback<Pokemon> {
                override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                }
                override fun onResponse(
                    call: Call<Pokemon>,
                    response: Response<Pokemon>
                ) {
                    list.add(response.body()!!)
                    pokemon.value = list
                }
            })
        }

        return pokemon
    }
}