package example.com.services

import redis.clients.jedis.Jedis

class RedisService {
    private val redisClient = Jedis("http://localhost:6379/")

    fun get(key: String?): String? {
        return redisClient.get(key)
    }

    fun set(key: String, value: String) {
        redisClient.set(key, value)
    }

    fun logError(location: String, error: String) {
        redisClient.lpush("error_logs", "Error for $location at ${java.time.LocalDateTime.now()}: $error")
    }
}