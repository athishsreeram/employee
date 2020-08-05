Employee SBA App

package com.springcloud.example.employee;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;

import java.util.ArrayList;
import java.util.Collection;

public class MultipleCacheResolver implements CacheResolver {
    
    private final CacheManager simpleCacheManager;
    private static final String EMPLOYEE = "Employee";
    
    public MultipleCacheResolver(CacheManager simpleCacheManager) {
        this.simpleCacheManager = simpleCacheManager;

    }
 
    @Override
    public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
        Collection<Cache> caches = new ArrayList<Cache>();
        if ("getEmployeeById".equals(context.getMethod().getName())) {
            caches.add(simpleCacheManager.getCache(EMPLOYEE));
        }
        return caches;
    }
}

package com.springcloud.example.employee;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipleCacheManagerConfig extends CachingConfigurerSupport {
 
    @Bean
    public CacheManager cacheManager() {
        return new SimpleCacheManager();
    }


}