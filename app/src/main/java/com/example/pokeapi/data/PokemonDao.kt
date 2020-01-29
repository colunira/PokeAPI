package com.example.pokeapi.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.pokeapi.model.Pokemon

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pokemon: Pokemon)

    @Query("SELECT name FROM pokemons")
    fun getAllPokemons(): LiveData<List<String>>

    @Query("SELECT name FROM pokemons WHERE isFavourite == 1")
    fun getAllFavouritePokemons(): LiveData<List<String>>

    @Delete
    fun deletePokemon(pokemon: Pokemon)
}