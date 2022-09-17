package ru.oksei.med.feature.routing

sealed class Route(val route: String) {
    object Splash: Route("splash")
    object Sign
}
