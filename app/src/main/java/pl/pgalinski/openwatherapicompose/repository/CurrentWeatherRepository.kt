package pl.pgalinski.openwatherapicompose.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import pl.pgalinski.openwatherapicompose.DefaultDispatcher
import pl.pgalinski.openwatherapicompose.IoDispatcher
import pl.pgalinski.openwatherapicompose.model.curren.weather.CurrentWeather
import pl.pgalinski.openwatherapicompose.network.CurrentWeatherService
import javax.inject.Inject

class CurrentWeatherRepository @Inject constructor(
    private val currentWeatherService: CurrentWeatherService,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {
    val apiKey: String = "9b3bdc24d3b435f42660ef05b456a95b"

    suspend fun fetchCurrentWeather(lat: Float, lon: Float): Result<CurrentWeather> {
       return withContext(ioDispatcher) {
            try {
                val data = currentWeatherService.fetchCurrentWeather(
                    lat,
                    lon,
                    apiKey
                )
                Result.success(data)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}