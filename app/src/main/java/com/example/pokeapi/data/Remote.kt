package com.example.pokeapi.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.pokeapi.model.Generation
import com.example.pokeapi.model.Pokemon
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

    fun getGenerationPokemons(id: Int): MutableLiveData<List<Pokemon>> {
        val pokemons = MutableLiveData<List<Pokemon>>()
        var generation: Generation? = Generation()
        val call = pokeService.getGenerationPokemons(id)
        call.enqueue(object : Callback<Generation> {
            override fun onFailure(call: Call<Generation>, t: Throwable) {
                Log.v("firstAPI ERROR", t.toString())
            }
            override fun onResponse(
                call: Call<Generation>,
                response: Response<Generation>
            ) {
                generation = response.body()
                Log.v("DOWEJ",generation!!.pokemons[0].name)
            }
        })



        return pokemons
    }
}