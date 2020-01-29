package com.example.pokeapi.ui.one

import android.os.Bundle
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
import androidx.navigation.fragment.findNavController
import com.example.pokeapi.model.NavigableFragment
import com.example.pokeapi.ui.home.HomeFragmentDirections
import kotlinx.android.synthetic.main.fragment_gen_one.*

class GenerationOneFragment : Fragment() {

    private lateinit var generationOneViewModel: GenerationOneViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        generationOneViewModel =
            ViewModelProviders.of(this).get(GenerationOneViewModel::class.java)
        return inflater.inflate(R.layout.fragment_gen_one, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
