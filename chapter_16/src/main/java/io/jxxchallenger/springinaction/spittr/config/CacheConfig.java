package io.jxxchallenger.springinaction.spittr.config;

import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.jxxchallenger.springinaction.spittr.model.Spittle;

@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {

    @Bean
    @Override
    public CacheManager cacheManager() {
        javax.cache.CacheManager cacheManager = Caching.getCachingProvider().getCacheManager();
        MutableConfiguration<Long, Spittle> spittleCache = new MutableConfiguration<Long, Spittle>().setTypes(Long.class, Spittle.class).setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(Duration.ONE_DAY)).setStoreByValue(false);
        cacheManager.createCache("spittleCache", spittleCache);
        JCacheCacheManager cacheCacheManager = new JCacheCacheManager(cacheManager);
        
        return cacheCacheManager;
    }

}
