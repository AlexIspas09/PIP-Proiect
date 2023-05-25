package com.plcoding.weatherapp.data.remote

import com.squareup.moshi.Json

// Weather data class where we get the values we need for each hour ( again, all information that can be taken for weather, only for an hour )
data class WeatherDto(
    @field:Json(name = "hourly")
    val weatherData: WeatherDataDto
)
