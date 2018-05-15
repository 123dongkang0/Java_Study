package com.request.test.dongk;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class RedisTest {
	
	private static JedisPoolConfig poolConfig;
	private static JedisPool pool;
	
	static {
		poolConfig = new JedisPoolConfig();
		/**
		 * 总的连接数 
		 */
		poolConfig.setMaxTotal(10);
		/**
		 *   向连接池借用连接时是否做连接有效性检测(ping),无效则会被移除。
		 * 每次借用多执行一次ping命令 
		 */
	    poolConfig.setTestOnBorrow(true);  
	    /**
	     *   向连接池归还连接时是否做有效性检测(ping), 无效连接会被移除，每次归还多执行
	     *  一次ping命令。  
	     */
	    poolConfig.setTestOnReturn(true);
	    /**
	     * 最大空闲连接数 ：及时没有数据库连接，依然可以最多保持5个连接而不被清除
	     */
	    poolConfig.setMaxIdle(5);
	    /**
	     *  最小空闲连接数 
	     */
	    poolConfig.setMinIdle(1);
	    /**
	     *  向连接池借用连接时是否做空闲检测，空闲超时的连接会被移除
	     */
	    poolConfig.setTestWhileIdle(true);
	    /**
	     *  做空闲连接检测时，每次的采样数
	     **/
	    poolConfig.setNumTestsPerEvictionRun(3);
        /**
         * 空闲连接的检测周期 
         */
	    poolConfig.setTimeBetweenEvictionRunsMillis(60000);
	    
	    try {
	    	pool = new JedisPool(poolConfig, "192.168.1.214", 6379, 6000,null,4);
	    }catch (Exception e) {
	    	e.printStackTrace();
		}
	    
	}
	
	private static int NUM_RETRIES = 5;   //最大尝试次数
	
	@Test
	public void set() {
		 int tries = 0;
         boolean sucess = false;
         String retVal = null;
         do {
             tries++;
             try {
                 Jedis jedis = pool.getResource();
                 retVal = jedis.set("redis-tomcat-test", "2018年5月5号");
                 jedis.close();
                 sucess = true;
             } catch (JedisConnectionException ex) {
            	 ex.printStackTrace();
                 if (tries == NUM_RETRIES)
                     throw ex;
             }
         } while (!sucess && tries <= NUM_RETRIES);
         System.out.println(retVal);
         //return (retVal != null) ? retVal : null;
	}
	
	/**
	 * 测试失效时间 
	 */
	@Test
	public void expire() {
        int tries = 0;
        boolean sucess = false;
        Long retVal = null;
        do {
            tries++;
            try {
                Jedis jedis = pool.getResource();
                retVal = jedis.expire("redis-tomcat-test", 1);
                jedis.close();
                sucess = true;
            } catch (JedisConnectionException ex) {
                if (tries == NUM_RETRIES)
                    throw ex;
            }
        } while (!sucess && tries <= NUM_RETRIES);
        //return retVal;
    }
	
	/**
	 * 测试获取key值 
	 */
	@Test
	 public void get() {
         int tries = 0;
         boolean sucess = false;
         byte[] retVal = null;
         do {
             tries++;
             try {
                 Jedis jedis = pool.getResource();
                 retVal = jedis.get("redis-tomcat-test".getBytes());
                 jedis.close();
                 sucess = true;
             } catch (JedisConnectionException ex) {
            	 ex.printStackTrace();
                 if (tries == NUM_RETRIES)
                     throw ex;
             }
         } while (!sucess && tries <= NUM_RETRIES);
         System.out.println(new String(retVal));
         // return retVal;
     }
	 
	/**
	 * 如果存在返回0
	 * 如果不存在保存，并返回1 
	 */
	@Test
	 public void setnx() {
         int tries = 0;
         boolean sucess = false;
         Long retVal = null;
         do {
             tries++;
             try {
                 Jedis jedis = pool.getResource();
                 retVal = jedis.setnx("redis-tomcat-test1", "2018年5月5号");
                 jedis.close();
                 sucess = true;
             } catch (JedisConnectionException ex) {
                 if (tries == NUM_RETRIES)
                     throw ex;
             }
         } while (!sucess && tries <= NUM_RETRIES);
         System.out.println(retVal);
       //  return retVal;
     }
	
	/**
	 * 删除key 
	 */
	@Test
	public void delete() {
        int tries = 0;
        boolean sucess = false;
        Long retVal = null;
        do {
            tries++;
            try {
                Jedis jedis = pool.getResource();
                retVal = jedis.del("redis-tomcat-test1");
                jedis.close();
                sucess = true;
            } catch (JedisConnectionException ex) {
                if (tries == NUM_RETRIES)
                    throw ex;
            }
        } while (!sucess && tries <= NUM_RETRIES);
       // return retVal;
    }

}
