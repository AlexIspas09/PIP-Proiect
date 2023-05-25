package com.plcoding.weatherapp.domain.weather

// using this class to access weather information for a certain day
data class WeatherInfo(
    val weatherDataPerDay: Map<Int, List<WeatherData>>,
    val currentWeatherData: WeatherData?
)
