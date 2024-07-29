package example.com.services

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlin.random.Random
import io.github.cdimascio.dotenv.dotenv

class WeatherService(private val redisService: RedisService) {
    private val apiKey = dotenv()["WEATHER_API_KEY"] ?: throw IllegalStateException("API Key not found")
    private val client = HttpClient(CIO)

    fun getWeatherFromCache(location: String?): String? {
        return redisService.get(location)
    }

    suspend fun fetchAndCacheWeatherData(location: String) {
        if (Random.nextDouble() < 0.2) throw Exception("The API Request Failed")

        val weatherData = fetchWeatherFromAPI(location)
        redisService.set(location, weatherData)
    }

    private suspend fun fetchWeatherFromAPI(location: String): String {
        return try {
            val response: HttpResponse = client.get("https://api.tomorrow.io/v4/weather/realtime") {
                parameter("location", location)
                parameter("apikey", apiKey)
                header("accept", "application/json")
            }
            response.body()
        } catch (e: Exception) {
            println("Error during API call: ${e.message}")
            throw e
        }
    }
}