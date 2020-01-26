package com.example.pokeapi.ui.three

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GenerationThreeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is generaion three Fragment"
    }
    val text: LiveData<String> = _text
}