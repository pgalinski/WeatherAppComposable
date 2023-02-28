package pl.pgalinski.openwatherapicompose.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import pl.pgalinski.openwatherapicompose.DefaultDispatcher
import pl.pgalinski.openwatherapicompose.IoDispatcher
import pl.pgalinski.openwatherapicompose.model.city.City
import javax.inject.Inject

class CityRepository @Inject constructor(
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun fetchCityList(): List<City> {
        return runBlocking(ioDispatcher) {
            delay(500)
            return@runBlocking listOf(
                City(id = 1, name = "Gdańsk", lat = 54.372158f, long = 18.638306f),
                City(id = 2, name = "Warszawa", lat = 52.23705f, long = 21.017532f),
                City(id = 3, name = "Poznań", lat = 52.40954f, long = 16.931992f),
                City(id = 4, name = "Kraków", lat = 50.049683f, long = 19.944544f),
                City(id = 5, name = "Wrocław", lat = 51.107883f, long = 17.038538f)
            )
        }
    }
}