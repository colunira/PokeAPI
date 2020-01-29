package com.example.pokeapi.ui.pokemon

import android.graphics.Color
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.example.pokeapi.R
import com.example.pokeapi.ui.home.HomeViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pokemon_view_fragment.view.*
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat


class PokemonFragment : Fragment() {

    companion object {
        fun newInstance() = PokemonFragment()
    }

    val picasso = Picasso.get()

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.pokemon_view_fragment, container, false)
        viewModel = ViewModelProviders.of(activity!!).get(HomeViewModel::class.java)
        viewModel.selectedPokemonName.observe(this, Observer { name ->
            viewModel.getPokemon(name, context!!).observe(this, Observer { pokemon ->

                // Load the picture
                picasso.load(pokemon.images.url).resize(200,200)
                    .into(view.imageView9)

                //Load pokemon data
                view.pokemonName.text=pokemon.name
                view.pokemonAttack.text=pokemon.stats[pokemon.ATTACK].value.toString()
                view.pokemonDefense.text=pokemon.stats[pokemon.DEFENSE].value.toString()
                view.pokemonHP.text=pokemon.stats[pokemon.HP].value.toString()
                view.pokemonSpeed.text=pokemon.stats[pokemon.SPEED].value.toString()
                view.pokemonWeight.text="${pokemon.weight} hg"
                view.pokemonHeight.text="${pokemon.height} dm"
                view.pokemonExp.text="${pokemon.experience} EXP"

                // setup the types
                var typeName = pokemon.types[0].type.name
                var color = pokemon.types[0].type.color[typeName]!!
                view.pokemonType1.text = typeName
                view.pokemonType1.setBackgroundColor(ContextCompat.getColor(this.context!!, color))
                if (pokemon.types.size > 1) {
                    typeName = pokemon.types[1].type.name
                    color = pokemon.types[1].type.color[typeName]!!
                    view.pokemonType2.text = typeName
                    view.pokemonType2.setBackgroundColor(ContextCompat.getColor(this.context!!, color))
                } else {
                    view.pokemonType2.text = ""
                    view.pokemonType2.setBackgroundColor(Color.TRANSPARENT)
                }
                if (pokemon.isFavourite) view.favourite.setImageResource(R.drawable.ic_star)

                // setup the abilities
                val abilitiesAdapter = ArrayAdapter<String>(
                    this.context!!,
                    R.layout.list_view_item,
                    pokemon.getAbilitiesAsStringList()
                )
                view.abilities.adapter=abilitiesAdapter

                // setup the moves
                val movesAdapter = ArrayAdapter<String>(
                    this.context!!,
                    R.layout.list_view_item,
                    pokemon.getMovesAsStringList()
                )
                view.moves.adapter=movesAdapter

                // set on click listener
                view.favourite.setOnClickListener {
                    if (pokemon.isFavourite) {
                        pokemon.isFavourite = false
                        view.favourite.setImageResource(R.drawable.ic_star_unchecked)
                        Thread {
                            viewModel.unlikePokemon(pokemon, context!!)
                        }.start()
                    } else {
                        pokemon.isFavourite = true
                        view.favourite.setImageResource(R.drawable.ic_star)
                        Thread {
                            viewModel.setFavouritePokemon(pokemon, context!!)
                        }.start()
                    }
                }
            })
        })
        return view
    }
}
