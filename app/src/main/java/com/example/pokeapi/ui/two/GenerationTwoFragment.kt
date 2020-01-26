package com.example.pokeapi.ui.two

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.pokeapi.R

class GenerationTwoFragment : Fragment() {

    private lateinit var generationTwoViewModel: GenerationTwoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        generationTwoViewModel =
            ViewModelProviders.of(this).get(GenerationTwoViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
        generationTwoViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}