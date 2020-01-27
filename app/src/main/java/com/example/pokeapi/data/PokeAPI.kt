package com.example.pokeapi.data

import com.example.pokeapi.model.Generation
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeAPI {
    @GET("generation/{id}")
    fun getGenerationPokemons(@Path("id") user: Int): Call<Generation>
}