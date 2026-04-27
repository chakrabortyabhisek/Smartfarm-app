package com.example.myapplication11.data.remote

import com.example.myapplication11.data.model.WeatherData
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    suspend fun getWeatherData(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String
    ): WeatherResponse
}

data class WeatherResponse(
    val main: Main,
    val name: String,
    val weather: List<WeatherDescription>
)

data class Main(
    val temp: Double,
    val humidity: Int
)

data class WeatherDescription(
    val description: String
)
