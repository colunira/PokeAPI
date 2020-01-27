package com.example.pokeapi.model

import com.google.gson.annotations.SerializedName

class Move {
    @SerializedName("id") val id: Int = 0
    @SerializedName("name") val name: String = ""
    @SerializedName("power") val power: Int = 0
    @SerializedName("damage_class") val damage_class: MoveDamageClass = MoveDamageClass()
}