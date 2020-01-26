package com.example.pokeapi.ui.two

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GenerationTwoViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is generation two Fragment"
    }
    val text: LiveData<String> = _text
}