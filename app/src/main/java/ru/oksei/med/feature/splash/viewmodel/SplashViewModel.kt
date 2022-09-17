package ru.oksei.med.feature.splash.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.oksei.med.feature.splash.model.SplashState
import javax.inject.Inject


@HiltViewModel
class SplashViewModel
@Inject constructor() : ViewModel() {
    private val _state = mutableStateOf<SplashState>(SplashState.Loading)

    val state : State<SplashState> get() = _state

    init {
        viewModelScope.launch {
            delay(4000)
            _state.value = SplashState.Error
        }
    }

}