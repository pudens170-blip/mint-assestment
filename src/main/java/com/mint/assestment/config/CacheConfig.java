package com.mint.assestment.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import net.sf.ehcache.config.CacheConfiguration;

@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {

	@Value("${cacheName}")
	private String cacheName;

	@Value("${memoryStoreEvictionPolicy}")
	private String memoryStoreEvictionPolicy;

	@Value("${maxEntriesLocalHeap}")
	private long maxEntriesLocalHeap;

	@Value("${timeToLiveSeconds}")
	private long timeToLiveSeconds;

	@Bean
	public net.sf.ehcache.CacheManager ehCacheManager() {
		CacheConfiguration cacheConfig = new CacheConfiguration();
		cacheConfig.setName(cacheName);
		cacheConfig.setMemoryStoreEvictionPolicy(memoryStoreEvictionPolicy);
		cacheConfig.setMaxEntriesLocalHeap(maxEntriesLocalHeap);
		cacheConfig.setTimeToLiveSeconds(timeToLiveSeconds);
		net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
		config.addCache(cacheConfig);
		return net.sf.ehcache.CacheManager.newInstance(config);
	}

	@Bean
	@Override
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheManager());
	}

}
