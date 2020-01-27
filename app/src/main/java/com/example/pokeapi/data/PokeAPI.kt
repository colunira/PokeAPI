package com.example.pokeapi.data

import com.example.pokeapi.model.Generation
import com.example.pokeapi.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeAPI {

    @GET("generation/{id}")
    fun getGeneration(@Path("id") id: Int): Call<Generation>

    @GET("pokemon/{name}")
    fun getPokemonByName(@Path("name") pokemon: String): Call<Pokemon>
}