package example.com.plugins

import example.com.routes.weatherRoutes
import example.com.services.RedisService
import example.com.services.WeatherService
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    val redisService = RedisService()
    val weatherService = WeatherService(redisService)

    routing {
        weatherRoutes(weatherService)
    }
}
