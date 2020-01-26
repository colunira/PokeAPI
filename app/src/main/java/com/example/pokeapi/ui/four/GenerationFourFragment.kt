package com.example.pokeapi.ui.four

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.pokeapi.R

class GenerationFourFragment : Fragment() {

    private lateinit var generationFourViewModel: GenerationFourViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        generationFourViewModel =
            ViewModelProviders.of(this).get(GenerationFourViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_share, container, false)
        val textView: TextView = root.findViewById(R.id.text_share)
        generationFourViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}