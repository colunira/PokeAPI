package com.example.pokeapi.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapi.R
import com.example.pokeapi.model.Pokemon

class PokemonListAdapter(val pokemons: List<Pokemon>, viewModel: ViewModel) : RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=
            LayoutInflater.from(parent.context).inflate(R.layout.pokemon_list_view, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder.pokemonName.text=pokemon.name
        holder.pokemonAttack.text=pokemon.stats[pokemon.ATTACK].value.toString()
        holder.pokemonDefense.text=pokemon.stats[pokemon.DEFENSE].value.toString()
        holder.pokemonHP.text=pokemon.stats[pokemon.HP].value.toString()
        holder.pokemonSpeed.text=pokemon.stats[pokemon.SPEED].value.toString()
        Log.v("POKE TYPE", pokemon.types[0].type.toString())
        holder.pokemonType1.text=pokemon.types[0].type.name
        if (pokemon.types.size>1) {
            holder.pokemonType2.text=pokemon.types[1].type.name
        }
        holder.favourite.setOnClickListener{
            if (pokemon.isFavourite) {
                holder.favourite.setImageResource(R.drawable.ic_star_unchecked)
                pokemon.isFavourite=false
            } else {
                holder.favourite.setImageResource(R.drawable.ic_star)
                pokemon.isFavourite=true
            }
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