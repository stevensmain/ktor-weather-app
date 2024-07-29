package example.com

import example.com.services.RedisService
import example.com.services.WeatherService
import example.com.utils.ErrorLogger
import kotlinx.coroutines.*

fun startWeatherDataScheduler() {
    val scope = CoroutineScope(Dispatchers.Default)
    val redisService = RedisService()
    val weatherService = WeatherService(redisService)

    val locations = listOf("Santiago", "Zurich", "Auckland", "Sydney", "London", "Georgia")

    scope.launch {
        while (isActive) {
            locations.forEach { location ->
                try {
                    weatherService.fetchAndCacheWeatherData(location)
                } catch (e: Exception) {
                    ErrorLogger.logError(location, e.message ?: "Unknown error")
                }
            }
            delay(300000) // 5 minutes
        }
    }
}