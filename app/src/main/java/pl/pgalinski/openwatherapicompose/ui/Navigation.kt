package pl.pgalinski.openwatherapicompose.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation

@Composable
fun WeatherAppNavigation(
    appState: WeatherAppState = rememberWeatherAooState()
){
    NavHost(
        navController = appState.navHostController,
        startDestination = "SplashScreen"
    ){
        this.loginGraph(appState.navHostController)
        this.loggedInUserGraph(appState.navHostController)
    }

}

fun NavGraphBuilder.loggedInUserGraph(navController: NavController){
    navigation(startDestination = "home", route = "home"){
        composable(route = "home"){

        }
        composable(route = "details/{lat}&{lon}"){

        }

    }
}

fun NavGraphBuilder.loginGraph(navController: NavController){
    navigation(startDestination = "username", route="login" ){
        composable(route = "username"){

        }
        composable(route = "password"){

        }
        composable(route = "register"){

        }
    }
}
