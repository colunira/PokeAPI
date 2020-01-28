package com.example.pokeapi.ui.one

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapi.R
import com.example.pokeapi.ui.PokemonListAdapter
import androidx.navigation.fragment.findNavController
import com.example.pokeapi.R
import com.example.pokeapi.model.NavigableFragment
import com.example.pokeapi.ui.home.HomeFragmentDirections

class GenerationOneFragment : Fragment(), NavigableFragment {

    private lateinit var generationOneViewModel: GenerationOneViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        generationOneViewModel =
            ViewModelProviders.of(this).get(GenerationOneViewModel::class.java)
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        generationOneViewModel.getPokemonNames(1).observe(this, Observer { names ->
            if (names != null) {
                generationOneViewModel.getPokemons(names).observe(this, Observer { pokes ->
                    if (pokes != null) {
                        pokemonList.layoutManager =
                            LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                        pokemonList.adapter = PokemonListAdapter(pokes, context!!)
                    }
                })
            }
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        generationOneViewModel.getGeneration().observe(this, Observer { gen ->
//            if (gen != null) {
//                generationOneViewModel.getPokemons(gen.pokemons).observe(this, Observer { data ->
//                    if (data != null) {
//                        pokemonList.layoutManager =
//                            LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
//                        pokemonList.adapter = PokemonListAdapter(data, this)
//                    }
//                })
//            }
//        })
//        pokemonList.addItemDecoration(
//            DividerItemDecoration(
//                pokemonList.getContext(),
//                DividerItemDecoration.VERTICAL
//            )
//        )
    }

    override fun navigateToPokemon() {
        val action =
            HomeFragmentDirections.navToPokemon()
        this.findNavController().navigate(action)
    }
}
