package ru.oksei.med.feature.splash.model

sealed class SplashState {
    object Loading: SplashState()
    object Success: SplashState()
    object Error:SplashState()
}