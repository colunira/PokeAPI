package com.example.pokeapi.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapi.R
import com.example.pokeapi.model.Pokemon

class PokemonListAdapter(val pokemons: List<Pokemon>) : RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=
            LayoutInflater.from(parent.context).inflate(R.layout.pokemon_list_view, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder.pokemonName.text=pokemon.name

        holder.favourite.setOnClickListener{

        }
        holder.itemView.setOnClickListener{

        }
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pokemonName = itemView.findViewById<TextView>(R.id.pokemonName)
        val pokemonDefense = itemView.findViewById<TextView>(R.id.pokemonDefense)
        val pokemonAttack = itemView.findViewById<TextView>(R.id.pokemonAttack)
        val pokemonHP = itemView.findViewById<TextView>(R.id.pokemonHP)
        val pokemonSpeed = itemView.findViewById<TextView>(R.id.pokemonSpeed)
        val pokemonType1 = itemView.findViewById<TextView>(R.id.pokemonType1)
        val pokemonType2 = itemView.findViewById<TextView>(R.id.pokemonType2)
        val favourite = itemView.findViewById<ImageView>(R.id.favourite)
    }
}