package pl.pgalinski.openwatherapicompose.repository

import pl.pgalinski.openwatherapicompose.model.curren.weather.CurrentWeather
import pl.pgalinski.openwatherapicompose.network.CurrentWeatherService
import javax.inject.Inject

class CurrentWeatherRepository @Inject constructor(
    private val currentWeatherService: CurrentWeatherService
) {
    val apiKey: String = "9b3bdc24d3b435f42660ef05b456a95b"

    suspend fun fetchCurrentWeather(lat: Float, lon: Float): CurrentWeather =
        currentWeatherService.fetchCurrentWeather(
            lat,
            lon,
            apiKey
        )
}