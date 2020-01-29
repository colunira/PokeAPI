package com.example.pokeapi.ui.one

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokeapi.data.Repository

class GenerationOneViewModel : ViewModel() {

    private val repository = Repository.getInstance()
    
}
