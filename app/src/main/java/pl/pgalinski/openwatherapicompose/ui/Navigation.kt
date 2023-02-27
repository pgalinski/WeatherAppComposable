package pl.pgalinski.openwatherapicompose.ui

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import pl.pgalinski.openwatherapicompose.ui.city.CityList
import pl.pgalinski.openwatherapicompose.ui.splashscreen.SplashScreen

private const val LOGGED_IN_ROUTE = "loggedIn"

@Composable
fun WeatherAppNavigation(
    appState: WeatherAppState = rememberWeatherAppState()
) {
    NavHost(
        navController = appState.navHostController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(
                navController = appState.navHostController
            )
        }
        loggedInUserGraph(appState.navHostController)
    }
}

fun NavGraphBuilder.loggedInUserGraph(navController: NavController) {
    navigation(startDestination = Screen.Home.route, LOGGED_IN_ROUTE) {
        composable(route = Screen.Home.route) {
            CityList(navController = navController)
        }
        composable(route = Screen.CurrentWeatherDetails.route) {
            Text("Details")
        }

    }
}


