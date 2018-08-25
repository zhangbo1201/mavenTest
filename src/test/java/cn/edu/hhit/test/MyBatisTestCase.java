package cn.edu.hhit.test;


import cn.edu.hhit.redisDao.RedisDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.web.context.WebApplicationContext;
import redis.clients.jedis.JedisPool;

import javax.servlet.ServletContext;
import javax.sql.DataSource;
import java.util.Calendar;
import java.util.Date;



public class MyBatisTestCase {

    ClassPathXmlApplicationContext ctx;

    WebApplicationContext app;
    ServletContext ser;
    @Before
    public void init(){
        ctx = new ClassPathXmlApplicationContext(
                "spring-web.xml",
                "spring-service.xml",
                "spring-mybatis.xml","spring-redis.xml");
    }
    @Test
    public void testDataSource(){
        DataSource ds = ctx.getBean(
                "dataSource", DataSource.class);
        System.out.println(ds);
    }
    @Test
    public void testSqlSessionFactory(){
        SqlSessionFactory factory=
                ctx.getBean("sqlSessionFactory",
                        SqlSessionFactory.class);
        System.out.println(factory);
    }

    @Test
    public void testMapperScanner(){
        MapperScannerConfigurer scanner=
                ctx.getBean("mapperScanner",
                        MapperScannerConfigurer.class);
        System.out.println(scanner);
    }
    @Test
    public void redistest() {
        RedisDao dao = ctx.getBean(RedisDao.class);
        JedisPool jedisPool = ctx.getBean(JedisPool.class);
        jedisPool.getResource().get("1");
        System.out.println(jedisPool.toString());
        dao.set("name", "chenhao");
        System.out.println(dao.get("name"));
        System.out.println(dao.listKey("USER"));
        RedisTemplate<String, Object> redisTemplate = ctx.getBean(RedisTemplate.class);
        ValueOperations<String, Object> valueOperations =  redisTemplate.opsForValue();
        RedisAtomicLong redisAtomicLong = ctx.getBean(RedisAtomicLong.class);
        System.out.println(valueOperations.get("name"));
        redisAtomicLong.expireAt(this.getTodayEndTime());
        System.out.println(redisAtomicLong.incrementAndGet());
        System.out.println(redisAtomicLong.incrementAndGet());
    }
    private static Date getTodayEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }
}