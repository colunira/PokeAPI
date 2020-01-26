package com.example.pokeapi.ui.four

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GenerationFourViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is generation four Fragment"
    }
    val text: LiveData<String> = _text
}