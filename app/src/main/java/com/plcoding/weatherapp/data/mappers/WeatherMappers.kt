package com.plcoding.weatherapp.data.mappers

import com.plcoding.weatherapp.data.remote.WeatherDataDto
import com.plcoding.weatherapp.data.remote.WeatherDto
import com.plcoding.weatherapp.domain.weather.WeatherData
import com.plcoding.weatherapp.domain.weather.WeatherInfo
import com.plcoding.weatherapp.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

// Define a private data class to hold indexed weather data
private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherData
)

// Extension function to map WeatherDataDto to a map of weather data
fun WeatherDataDto.toWeatherDataMap(): Map<Int, List<WeatherData>> {
    // Map each time entry to IndexedWeatherData object
    return time.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]
        val windSpeed = windSpeeds[index]
        val pressure = pressures[index]
        val humidity = humidities[index]
        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                pressure = pressure,
                windSpeed = windSpeed,
                humidity = humidity,
                weatherType = WeatherType.fromWMO(weatherCode)
            )
        )
    }.groupBy {
        // Group the weather data by day
        it.index / 24
    }.mapValues {
        // Extract only the weather data from IndexedWeatherData objects
        it.value.map { it.data }
    }
}

// Extension function to map WeatherDto to WeatherInfo
fun WeatherDto.toWeatherInfo(): WeatherInfo {
    // Get the weather data map
    val weatherDataMap = weatherData.toWeatherDataMap()
    
    // Get the current weather data based on the current time
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if(now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }
    // Return the WeatherInfo object
    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )
}
