package com.example.pokeapi.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapi.MainActivity
import com.example.pokeapi.R
import com.example.pokeapi.data.PokemonDatabase
import com.example.pokeapi.model.NavigableFragment
import com.example.pokeapi.model.Pokemon
import com.example.pokeapi.ui.home.HomeViewModel
import com.squareup.picasso.Picasso
import java.util.*

class PokemonListAdapter(
    val pokemons: List<Pokemon>,
    private val context: Context,
    private val viewModel: HomeViewModel,
    private val parent: NavigableFragment
) : RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {

    val picasso = Picasso.get()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.pokemon_list_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemons[position]

        // Get pokemon image
        picasso.load(pokemon.images.url).resize(200, 200)
            .into(holder.image)

        // Fill fields
        holder.pokemonName.text = pokemon.name.capitalize()
        holder.pokemonAttack.text = pokemon.stats[pokemon.ATTACK].value.toString()
        holder.pokemonDefense.text = pokemon.stats[pokemon.DEFENSE].value.toString()
        holder.pokemonHP.text = pokemon.stats[pokemon.HP].value.toString()
        holder.pokemonSpeed.text = pokemon.stats[pokemon.SPEED].value.toString()
        holder.pokemonType1.text = pokemon.types[0].type.name
        if (pokemon.types.size > 1) {
            holder.pokemonType2.text = pokemon.types[1].type.name
        } else {
            holder.pokemonType2.text = ""
        }
        if (pokemon.isFavourite) holder.favourite.setImageResource(R.drawable.ic_star)

        //OnClick listeners
        holder.favourite.setOnClickListener {
            if (pokemon.isFavourite) {
                pokemon.isFavourite = false
                holder.favourite.setImageResource(R.drawable.ic_star_unchecked)
                Thread {
                    viewModel.unlikePokemon(pokemon, context)
                }.start()
            } else {
                pokemon.isFavourite = true
                holder.favourite.setImageResource(R.drawable.ic_star)
                Thread {
                    viewModel.setFavouritePokemon(pokemon, context)
                }.start()
            }
        }

        //Funkcja do testu!!
        holder.pokemonName.setOnClickListener {
            Toast.makeText(context, pokemon.toString(), Toast.LENGTH_SHORT).show()
        }


        holder.itemView.setOnClickListener {
            parent.navigateToPokemon(pokemon.name)
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
        val image = itemView.findViewById<ImageView>(R.id.imageView9)
    }
}
