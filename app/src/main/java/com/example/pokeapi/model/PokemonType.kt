package com.example.pokeapi.model

import com.google.gson.annotations.SerializedName

class PokemonType {
    @SerializedName("types") val type: Type = Type()
}