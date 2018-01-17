package com.example.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.domain.ReplyDomain;

@Configuration
@EnableCaching
public class RedisConfig {
	
	private @Value("${spring.redis.host}") String redisHost;
	private @Value("${spring.redis.port}") int redisPort;
	
	@Bean
	public CacheManager cacheManager(RedisTemplate redisTemplete) {
		return new RedisCacheManager(redisTemplete);
	}
	
	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setHostName(redisHost);
		jedisConnectionFactory.setPort(redisPort);
		return jedisConnectionFactory;
	}
	
	@Primary
	@Bean
	public RedisTemplate<String, List<ReplyDomain>> redisTemplate(RedisConnectionFactory redisCF){
		RedisTemplate<String, List<ReplyDomain>> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisCF);
		return redisTemplate;
	}
}
