package com.baizhi.util;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SerializationUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Set;

/**
 * 自定义缓存管理器 并且将缓存地内容存入Redis数据库中
 * 2018年12月20日 11点36分
 *      降低对数据库地访问，提高系统地性能
 */

public class MyCacheConfig implements Cache {

    @Autowired
    private Jedis jedis;

    public MyCacheConfig(String host,int port){
        this.jedis = new Jedis(host,port);
    }

    @Override
    public Object get(Object k) throws CacheException {
        // 同样利用k 序列化 去Redis中取
        byte[] bytes = jedis.get(SerializationUtils.serialize(k));
        // 利用反序列化 将bytes数组 转换为Object类型
        Object deserialize = SerializationUtils.deserialize(bytes);
        return deserialize;
    }

    @Override
    public Object put(Object k, Object v) throws CacheException {
        // 将存入地k(身份信息账号) v 序列化(身份验证类的地址值)，顺应set方法的同时方便存取
        System.out.println(SerializationUtils.serialize(k));
        System.out.println(SerializationUtils.serialize(v));
        jedis.set(SerializationUtils.serialize(k),SerializationUtils.serialize(v));
        return jedis;
    }

    @Override
    public Object remove(Object k) throws CacheException {
        // 因为存入的是序列化k v 所以将参数k序列化
        jedis.del(SerializationUtils.serialize(k));
        return jedis;
    }

    @Override
    public void clear() throws CacheException {
        //调用Jedis的flushDB清空0号数据库
        jedis.flushDB();
    }

    @Override
    public int size() {
        //调用Jedis的dbSize获取0号数据库长度
        Long size = jedis.dbSize();
        //返回值为int 将size转换为int类型
        int value = size.intValue();
        return value;
    }

    @Override
    public Set keys() {
        //调用Jedis中的获取所有Key方法
        Set<String> keys = jedis.keys("*");
        return keys;
    }

    @Override
    public Collection values() {
        //调用Jedis中的获取所有v的方法
        Set<String> keys = jedis.keys("*");
        Collection<String> collection = null;
        //利用"入"表达式将得到的Key去取值
        keys.forEach(key ->collection.add(jedis.get(key)));
        return collection;
    }
}
