package cn.edu.hhit.redisDao;

import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.List;

public class RedisDaoImpl implements RedisDao {
    @Resource
    private JedisPool jedisPool;

    @Override
    public String get(String key) {
        return jedisPool.getResource().get(key);
    }

    @Override
    public String set(String key, String value) {
        jedisPool.getResource().expireAt(key,System.currentTimeMillis()+10*60*1000L);
        return jedisPool.getResource().set(key, value);
    }

    @Override
    public String hget(String hkey, String key) {
        return jedisPool.getResource().hget(hkey, key);
    }

    @Override
    public long hset(String hkey, String key, String value) {
        return jedisPool.getResource().hset(hkey, key, value);
    }

    @Override
    public <T> List<T> listKey(String key) {
        return (List<T>) jedisPool.getResource().lrange(key, 0, -1);
    }
}
