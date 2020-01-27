package com.example.pokeapi.model

import com.google.gson.annotations.SerializedName

class PokemonStat {
    @SerializedName("base_stat") val value: Int = 0
    @SerializedName("stat") val stat: Stat = Stat()
}