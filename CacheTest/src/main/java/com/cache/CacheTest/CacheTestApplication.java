package com.cache.CacheTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class CacheTestApplication {
	public static final String GAS_AUDIT = "GAS_AUDIT";

	public static void main(String[] args) {
		SpringApplication.run(CacheTestApplication.class, args);
	}

	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager(GAS_AUDIT);
	}

	@CacheEvict(allEntries = true, value = { GAS_AUDIT })
	@Scheduled(fixedDelay = 10 * 60 * 10, initialDelay = 500)
	public void reportCacheEvict() {
		System.out.println(Thread.currentThread().getName());
	}

}
