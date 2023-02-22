package pl.pgalinski.openwatherapicompose.model.curren.weather

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrentWeather(
    val coord: Coord,
    val weather: List<WeatherDescription>,
    val base: String,
    val main: MainWeatherParams,
    val visibility: Int,
    val wind: Wind,
    val rain: Fall,
    val snow: Fall,
    val clouds: Clouds,
    val dt: Long,
    val sys: Sys,
    val timezone: Int,
    val id: Long,
    val name: String,
    val cod: Int
) : Parcelable

@Parcelize
data class Sys(
    val type: Int,
    val id: Long,
    val country: String,
    val sunrise: Int,
    val sunset: Int
) : Parcelable

@Parcelize
data class Clouds(
    val all: Int
) : Parcelable

@Parcelize
data class Wind(
    val speed: Float,
    val deg: Int,
    val gust: Float
) : Parcelable

@Parcelize
data class Fall(
    /** Amount of fall during past hour */
    val h1: Float,
    /** Amount of fall during past 3 hours */
    val h3: Float = 0f
) : Parcelable

@Parcelize
data class Coord(
    val lon: Long,
    val lat: Long
) : Parcelable

@Parcelize
data class WeatherDescription(
    val id: Long,
    val main: String,
    val description: String,
    val icon: String
) : Parcelable

@Parcelize
data class MainWeatherParams (
    val temp: Float,
    val feelsLike: Float,
    val tempMin: Float,
    val tempMax: Float,
    val pressure: Int,
    val humidity: Int,
    /** Atmospheric pressure on the sea level, hPa */
    val seaLevel: Int,
    /** Atmospheric pressure on the ground level, hPa */
    val grndLevel: Int
) : Parcelable