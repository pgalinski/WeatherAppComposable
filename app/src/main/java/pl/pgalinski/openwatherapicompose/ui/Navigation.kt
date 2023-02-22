package pl.pgalinski.openwatherapicompose.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import pl.pgalinski.openwatherapicompose.ui.splashscreen.SplashScreen

@Composable
fun WeatherAppNavigation(
    appState: WeatherAppState = rememberWeatherAppState()
){
    NavHost(
        navController = appState.navHostController,
        startDestination = "splashScreen"
    ){
        composable("splashScreen"){
            SplashScreen(
                navController = appState.navHostController
            )
        }
        loginGraph(appState.navHostController)
        loggedInUserGraph(appState.navHostController)
    }

}

fun NavGraphBuilder.loggedInUserGraph(navController: NavController){
    navigation(startDestination = "home","loggedIn"){
        composable(route = "home"){
            Text("Home")
        }
        composable(route = "details/{lat}&{lon}"){
            Text("Details")
        }

    }
}

fun NavGraphBuilder.loginGraph(navController: NavController){
    navigation(startDestination = "username", route="login" ){
        composable(route = "username"){
            Text("Username")
        }
        composable(route = "password"){
            Text("Password")
        }
        composable(route = "register"){
            Text("Register")
        }
    }
}
