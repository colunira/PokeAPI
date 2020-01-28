package com.example.pokeapi.model

import com.google.gson.annotations.SerializedName

class PokemonType {
    @SerializedName("type") val type: Type = Type()
}