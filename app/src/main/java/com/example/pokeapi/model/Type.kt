package com.example.pokeapi.model

import com.example.pokeapi.R
import com.google.gson.annotations.SerializedName

class Type {
    @SerializedName("id") val id: Int = 0
    @SerializedName("name") val name: String = ""

    val color: Map<String, Int> = mapOf(
        Pair("fire", R.color.typeFire),
        Pair("normal",R.color.typeNormal),
        Pair("water",R.color.typeWater),
        Pair("grass",R.color.typeGrass),
        Pair("electric",R.color.typeElectric),
        Pair("ice",R.color.typeIce),
        Pair("fighting",R.color.typeFighting),
        Pair("poison",R.color.typePoison),
        Pair("ground",R.color.typeGround),
        Pair("flying",R.color.typeFlying),
        Pair("psychic",R.color.typePsychic),
        Pair("bug",R.color.typeBug),
        Pair("rock",R.color.typeRock),
        Pair("ghost",R.color.typeGhost),
        Pair("dark",R.color.typeDark),
        Pair("dragon",R.color.typeDragon),
        Pair("steel",R.color.typeSteel),
        Pair("fairy",R.color.typeFairy)
    )
    override fun toString(): String {
        return "$id. $name"
    }
}