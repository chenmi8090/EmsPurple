package com.baizhi.cache;

import com.baizhi.util.MyCacheConfig;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

public class MyCacheManager implements CacheManager {

    private MyCacheConfig myCacheConfig;

    public MyCacheManager(String host,int port){
        this.myCacheConfig = new MyCacheConfig(host,port);
    }

    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return myCacheConfig;
    }
}
