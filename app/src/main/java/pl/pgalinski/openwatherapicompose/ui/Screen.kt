package pl.pgalinski.openwatherapicompose.ui

sealed class Screen(val route: String){
    object SplashScreen: Screen(route = "splashScreen")
    object Home: Screen(route = "home")
    object CurrentWeatherDetails: Screen("currentWeatherDetails/{lat}&{lon}"){
        fun createRoute(lat: Float, lon: Float) = "currentWeatherDetails/$lat&$lon"
    }
}
