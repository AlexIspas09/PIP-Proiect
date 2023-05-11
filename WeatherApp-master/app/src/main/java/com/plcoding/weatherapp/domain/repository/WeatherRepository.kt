package com.plcoding.weatherapp.domain.repository

import com.plcoding.weatherapp.domain.util.Resource

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}