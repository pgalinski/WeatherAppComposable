package pl.pgalinski.openwatherapicompose.repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import pl.pgalinski.openwatherapicompose.model.city.City
import javax.inject.Inject

class CityRepository @Inject constructor() {

    suspend fun fetchCityList(): List<City>{
        return runBlocking {
            delay(500)
            return@runBlocking listOf(
                City("Gdańsk", 54.372158f, 18.638306f),
                City("Warszawa", 52.23705f, 21.017532f),
                City("Poznań", 52.40954f, 16.931992f),
                City("Kraków", 50.049683f, 19.944544f),
                City("Wrocław", 51.107883f, 17.038538f)
            )
        }
    }
}