package pl.pgalinski.openwatherapicompose.ui.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import pl.pgalinski.openwatherapicompose.R

@Preview
@Composable
fun SplashScreen(){
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
        Image(
           painter = painterResource(
                id = R.drawable.partly_cloudy_day_48px
            ),
            contentDescription = "Splash screen logo",
            Modifier.align(
                alignment = Alignment.Center
            )
                .scale(2f)

        )
    }



}