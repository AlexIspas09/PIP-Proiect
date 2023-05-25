package com.plcoding.weatherapp.data.repository

import com.plcoding.weatherapp.data.mappers.toWeatherInfo
import com.plcoding.weatherapp.data.remote.WeatherApi
import com.plcoding.weatherapp.domain.repository.WeatherRepository
import com.plcoding.weatherapp.domain.util.Resource
import com.plcoding.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

// Implementation of the WeatherRepository interface
class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    // Retrieve weather data for the given latitude and longitude
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            // Try to get the weather data from the API and map it to WeatherInfo
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch(e: Exception) {
            // If an exception occurs, handle it and return an error resource
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}
