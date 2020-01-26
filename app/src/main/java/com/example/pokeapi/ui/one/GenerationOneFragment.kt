package com.example.pokeapi.ui.one

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.pokeapi.R

class GenerationOneFragment : Fragment() {

    private lateinit var generationOneViewModel: GenerationOneViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        generationOneViewModel =
            ViewModelProviders.of(this).get(GenerationOneViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        generationOneViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}