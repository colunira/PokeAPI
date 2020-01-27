package com.example.pokeapi.model

import com.google.gson.annotations.SerializedName

class Generation {
    @SerializedName("id") val id: Int = 0
    @SerializedName("name") val name: String = ""
    @SerializedName("pokemon_species") val pokemons: MutableList<PokemonSpecies> = mutableListOf()
}