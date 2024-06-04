package com.example.hw02

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class SaveModel(val currentview:viewdetail=views[0])

class viewmodel : ViewModel(){
    private val _uiState = MutableStateFlow(SaveModel())
    val uiState: StateFlow<SaveModel> = _uiState.asStateFlow()

    public fun Set(Viewdetail: viewdetail) {
        _uiState.update { currentState ->
            currentState.copy(currentview = Viewdetail)
        }
    }
    public fun Get(): viewdetail {
        return uiState.value.currentview
    }

}