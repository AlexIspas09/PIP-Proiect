package com.plcoding.weatherapp.domain.util

// Sealed class representing a resource with data and optional message
sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    // Subclass representing a successful resource with optional data
    class Success<T>(data: T?): Resource<T>(data)
    
    // Subclass representing an error resource with a message and optional data
    class Error<T>(message: String, data: T? = null): Resource<T>(data, message)
}
