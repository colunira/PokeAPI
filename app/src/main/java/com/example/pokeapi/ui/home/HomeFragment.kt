package com.example.pokeapi.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapi.R
import com.example.pokeapi.ui.PokemonListAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.pokeapi.model.Pokemon

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        homeViewModel.getGeneration().observe(this, Observer { gen ->
            if (gen != null) {
                homeViewModel.getPokemons(gen.pokemons).observe(this, Observer { data ->
                    if (data != null) {
                        pokemonList.layoutManager =
                            LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                        pokemonList.adapter = PokemonListAdapter(data, homeViewModel)
                        val dividerItemDecoration = DividerItemDecoration(
                            pokemonList.getContext(),
                            1
                        )
                        pokemonList.addItemDecoration(dividerItemDecoration)
                    }
                    else {
                        Log.v("NIE","DZIALA")
                    }
                })
            }
            else {
                Log.v("NIE","MA GENERACJI")
            }
        })
    }
}