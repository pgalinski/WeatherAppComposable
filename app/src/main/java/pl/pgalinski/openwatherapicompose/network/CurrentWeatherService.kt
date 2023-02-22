package pl.pgalinski.openwatherapicompose.network

import pl.pgalinski.openwatherapicompose.model.curren.weather.CurrentWeather
import retrofit2.http.GET
import retrofit2.http.Path


interface CurrentWeatherService {

    @GET("/weather?lat={lat}&lon={lon}&appid={apiKey}")
    fun fetchCurrentWeather(
        @Path("lat")
        lat: Float,
        @Path("lon")
        lon: Float,
        @Path("apiKey")
        apiKey: String
    ):CurrentWeather

}