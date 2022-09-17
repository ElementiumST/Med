package ru.oksei.med.feature.splash

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.min
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import ru.oksei.med.R
import ru.oksei.med.feature.splash.model.SplashState
import ru.oksei.med.feature.splash.viewmodel.SplashViewModel

@Composable
fun SplashScreen(
    hiltViewModel: SplashViewModel = hiltViewModel()
) {
    val keyState = hiltViewModel.state.value
    
    LaunchedEffect(keyState){
        when(keyState){
            SplashState.Error -> {}
            SplashState.Loading -> {}
            SplashState.Success -> {

            }
        }
    }
    val infiniteTransition = rememberInfiniteTransition()
    val scale by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000),
            repeatMode = RepeatMode.Restart
        ),
    )
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        val size = min(maxHeight,maxWidth)/2.5f
        Image(
            painter = painterResource(R.drawable.ic_atoms_medical),
            contentDescription = "Logo",
            modifier = Modifier
                .size(size)
                .rotate(scale)
        )
    }
}