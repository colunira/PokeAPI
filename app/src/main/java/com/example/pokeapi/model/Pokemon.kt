package com.example.pokeapi.model

import com.google.gson.annotations.SerializedName


class Pokemon {
    val SPEED=0
    val DEFENSE=3
    val ATTACK=4
    val HP=5

    @SerializedName("id") val id: Int = 0
    @SerializedName("name") val name: String = ""
    @SerializedName("base_experience") val experience: Int = 0
    @SerializedName("height") val height: Int = 0
    @SerializedName("weight") val weight: Int = 0
    @SerializedName("abilities") val abilities: MutableList<Ability> = mutableListOf()
    @SerializedName("moves") val moves: MutableList<Move> = mutableListOf()
    @SerializedName("sprites") val images: Sprite = Sprite()
    @SerializedName("stats") val stats: MutableList<PokemonStat> = mutableListOf()
    @SerializedName("type") val type: MutableList<Type> = mutableListOf()
}