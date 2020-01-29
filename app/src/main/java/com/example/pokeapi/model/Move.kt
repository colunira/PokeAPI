package com.example.pokeapi.model

import com.google.gson.annotations.SerializedName

class Move {
    @SerializedName("id") val id: Int = 0
    @SerializedName("name") val name: String = ""

    override fun toString(): String {
        return name
    }
}