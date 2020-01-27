package com.example.pokeapi.model

import com.google.gson.annotations.SerializedName

class Pokemon {
    @SerializedName("id") val id: Int = 0
    @SerializedName("name") val name: String = ""
    @SerializedName("base_experience") val experience: Int = 0
    @SerializedName("height") val height: Int = 0
}