package com.example.springcache.config;


import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Configuration
@EnableCaching
@EnableScheduling
public class CacheConfig {
    public static final String GAMES = "student";

    @Bean
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager(GAMES);

        return cacheManager;
    }

    @CacheEvict(allEntries = true, value = {GAMES})
    @Scheduled(fixedDelay = 30 * 1000,  initialDelay = 500)
    public void reportCacheEvict() {
        System.out.println("Flush Cache " );
    }
}