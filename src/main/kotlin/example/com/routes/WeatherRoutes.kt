package example.com.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import example.com.services.WeatherService

fun Route.weatherRoutes(weatherService: WeatherService) {
    route("/weather") {
        get("/{location}") {
            val location = call.parameters["location"]
            val weatherData = weatherService.getWeatherFromCache(location)
            if (weatherData != null) {
                call.respond(weatherData)
            } else {
                call.respond("No data found for location: $location")
            }
        }
    }
}