package com.example.pokeapi.ui.three

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.pokeapi.R

class GenerationThreeFragment : Fragment() {

    private lateinit var generationThreeViewModel: GenerationThreeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        generationThreeViewModel =
            ViewModelProviders.of(this).get(GenerationThreeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_tools, container, false)
        val textView: TextView = root.findViewById(R.id.text_tools)
        generationThreeViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}