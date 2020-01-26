package com.example.pokeapi.ui.one

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GenerationOneViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is generation one Fragment"
    }
    val text: LiveData<String> = _text
}