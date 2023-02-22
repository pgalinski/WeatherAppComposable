package pl.pgalinski.openwatherapicompose.network

import pl.pgalinski.openwatherapicompose.model.curren.weather.CurrentWeather
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface CurrentWeatherService {

    @GET("/weather")
    fun fetchCurrentWeather(
        @Query("lat")
        lat: Float,
        @Query("lon")
        lon: Float,
        @Query("appid")
        apiKey: String
    ): CurrentWeather

}