package com.springcloud.example.employee;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;

import java.util.ArrayList;
import java.util.Collection;

public class MultipleCacheResolver implements CacheResolver {
    
    private final CacheManager simpleCacheManager;
    private static final String EMPLOYEE = "employee";
    
    public MultipleCacheResolver(CacheManager simpleCacheManager) {
        this.simpleCacheManager = simpleCacheManager;

    }
 
    @Override
    public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
        Collection<Cache> caches = new ArrayList<Cache>();
        if ("findEmployeeById".equals(context.getMethod().getName())) {
            caches.add(simpleCacheManager.getCache(EMPLOYEE));
        }
        return caches;
    }
}