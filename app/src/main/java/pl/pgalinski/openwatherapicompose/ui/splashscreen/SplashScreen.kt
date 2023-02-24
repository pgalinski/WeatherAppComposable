package pl.pgalinski.openwatherapicompose.ui.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import pl.pgalinski.openwatherapicompose.R
import pl.pgalinski.openwatherapicompose.ui.Screen

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashScreenViewModel = hiltViewModel()
) {

    Box(
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.LightGray,
                        Color.Blue
                    )
                )
            )
    ) {
        Text(text = viewModel.textToshow)
        Image(
            painter = painterResource(
                id = R.drawable.partly_cloudy_day_48px
            ),
            contentDescription = "Splash screen logo",
            Modifier
                .align(
                    alignment = Alignment.Center
                )
                .scale(2f)

        )
    }

    LaunchedEffect(key1 = true) {
        delay(5000)
        navController.navigate(
            route = Screen.Home.route
        )
    }


}