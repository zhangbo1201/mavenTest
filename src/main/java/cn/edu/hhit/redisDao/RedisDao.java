package cn.edu.hhit.redisDao;

import java.util.List;

public interface RedisDao {

  String get(String key);

  String set(String key, String value);

  String hget(String hkey, String key);

  long hset(String hkey, String key, String value);

  <T> List<T> listKey(String key);
}
