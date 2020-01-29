package com.example.pokeapi.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import com.google.gson.annotations.SerializedName
import androidx.room.PrimaryKey

@Entity(tableName = "pokemons")
class Pokemon {
    var SPEED=0
    var DEFENSE=3
    var ATTACK=4
    var HP=5

    @PrimaryKey
    @SerializedName("id")
    var id: Int = 0

    @SerializedName("name")
    var name: String = ""

    @Ignore
    @SerializedName("base_experience")
    var experience: Int = 0

    @Ignore
    @SerializedName("height")
    var height: Int = 0

    @Ignore
    @SerializedName("weight")
    var weight: Int = 0

    @Ignore
    @SerializedName("abilities")
    var abilities: MutableList<PokemonAbility> = mutableListOf()

    @Ignore
    @SerializedName("moves")
    var moves: MutableList<PokemonMove> = mutableListOf()

    @Ignore
    @SerializedName("sprites")
    var images: Sprite = Sprite()

    @Ignore
    @SerializedName("stats")
    var stats: MutableList<PokemonStat> = mutableListOf()

    @Ignore
    @SerializedName("types")
    var types: MutableList<PokemonType> = mutableListOf()

    @ColumnInfo(name = "isFavourite")
    var isFavourite: Boolean = false

    override fun toString(): String {
        return "$id $name"
    }

    fun getAbilitiesAsStringList(): List<String> {
        val list: MutableList<String> = mutableListOf()
        for (item in abilities) {
            list.add(item.ability.name)
        }
        return list
    }

    fun getMovesAsStringList(): List<String> {
        val list: MutableList<String> = mutableListOf()
        for (item in moves) {
            list.add(item.move.toString())
        }
        return list
    }
}