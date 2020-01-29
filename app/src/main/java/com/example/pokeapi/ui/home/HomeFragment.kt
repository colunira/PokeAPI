package com.example.pokeapi.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapi.R
import com.example.pokeapi.ui.PokemonListAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.pokeapi.model.NavigableFragment


class HomeFragment : Fragment(), NavigableFragment {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(activity!!).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        homeViewModel.generationID.observe(this, Observer {
            homeViewModel.getPokemonNames(homeViewModel.generationID.value!!, context).observe(this, Observer { favs ->
                if (favs != null) {
                    homeViewModel.getPokemons(favs).observe(this, Observer { pokes ->
                        if (pokes != null) {
                            pokemonList.layoutManager =
                                LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                            pokemonList.adapter = PokemonListAdapter(pokes, context!!, this)
                        }
                    })
                }
            })
        })

        pokemonList.addItemDecoration(
            DividerItemDecoration(
                pokemonList.getContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }

    override fun navigateToPokemon(name: String) {
        val action =
            HomeFragmentDirections.navToPokemon()
        this.findNavController().navigate(action)
        homeViewModel.selectedPokemonName.value=name
    }
}
