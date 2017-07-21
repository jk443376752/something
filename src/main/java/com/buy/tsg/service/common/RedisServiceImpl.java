package com.buy.tsg.service.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
@Service
public class RedisServiceImpl {
    @Autowired
    private JedisPool jedisPool;
    
	public  boolean  set(String key,String value) throws Exception{
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set(key, value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			jedisPool.returnResource(jedis);
		}
	}
	
	public  boolean  set(String key,Object value){
		Jedis jedis = null;
		try {
			String objectJson = JSON.toJSONString(value);
			jedis = jedisPool.getResource();
			jedis.set(key, objectJson);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			jedisPool.returnResource(jedis);
		}
	}
	
	public  boolean del(String key){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.del(key);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			jedisPool.returnResource(jedis);
		}
	}
	
	public  Object get(String key){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Object value = jedis.get(key);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			jedisPool.returnResource(jedis);
		}
	}
	

	public  <T> T get(String key,Class<T> clazz){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String value = jedis.get(key);
			return JSON.parseObject(value, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			jedisPool.returnResource(jedis);
		}
	}
}
