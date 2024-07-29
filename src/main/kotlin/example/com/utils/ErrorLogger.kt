package example.com.utils

import example.com.services.RedisService

object ErrorLogger {
    private val redisService = RedisService()

    fun logError(location: String, error: String) {
        redisService.logError(location, error)
    }
}
