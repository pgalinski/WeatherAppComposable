package pl.pgalinski.openwatherapicompose.ui

import android.content.Context
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun rememberWeatherAppState(
    navController: NavHostController = rememberNavController(),
    context: Context = LocalContext.current
) = remember(navController, context) {
    WeatherAppState(navController, context)
}

class WeatherAppState(
    val navHostController: NavHostController,
    private val context: Context
) {

    var isOnline by mutableStateOf(checkOnline())
        private set


    var isLoggedIn by mutableStateOf(checkLogin())
        private set

    private fun checkLogin(): Boolean {
        //just for now
        return false
    }

    fun checkOnline(): Boolean = true

}