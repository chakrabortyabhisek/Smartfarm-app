package com.example.myapplication11.data.model

data class WeatherData(
    val temperature: Double = 0.0,
    val humidity: Int = 0,
    val condition: String = "",
    val location: String = ""
)

data class SoilData(
    val moisture: Int = 0,
    val phLevel: Double = 0.0,
    val nitrogen: Int = 0,
    val phosphorus: Int = 0,
    val potassium: Int = 0,
    val timestamp: Long = System.currentTimeMillis()
)

data class FarmStatus(
    val weather: WeatherData = WeatherData(),
    val soil: SoilData = SoilData(),
    val lastUpdate: Long = System.currentTimeMillis()
)
