package com.example.pokeapi.model

import com.google.gson.annotations.SerializedName

class PokemonAbility {
    @SerializedName("ability") val ability: Ability = Ability()
}