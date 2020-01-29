package com.example.pokeapi.model

import com.google.gson.annotations.SerializedName

class PokemonMove {
    @SerializedName("move") val move: Move = Move()
}