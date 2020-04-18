package com.drawdream.app.base.utils;

import cn.hutool.db.nosql.redis.RedisDS;
import cn.hutool.json.JSONUtil;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @desc: todo
 * @package: com.drawdream.app.base.utils
 * @fileName: Redis
 * @author: tanhao
 * @date: 2020-04-18 14:47
 */
public class RedisUtil {
    private static Jedis jedis = RedisDS.create().getJedis();

    /**
     * @param key,time
     * @desc: 设置过期时间
     * @author: tanhao
     * @date: 2020-04-18 14:52
     */
    public boolean expire(String key,int time){
        try {
            if(time>0){
                jedis.expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param key
     * @desc: 获取key过期时间
     * @author: tanhao
     * @date: 2020-04-18 14:52
     */
    public long getExpire(String key){
        return jedis.ttl(key);
    }

    /**
     * @param key
     * @desc: 验证key是否存在
     * @author: tanhao
     * @date: 2020-04-18 14:53
     */
    public boolean hasKey(String key){
        try {
            return jedis.exists(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param key
     * @desc: 删除redis
     * @author: tanhao
     * @date: 2020-04-18 14:56
     */
    public void del(String key){
        jedis.del(key);
    }

    /**
     * @param key
     * @param value
     * @desc: 添加redis String类型
     * @author: tanhao
     * @date: 2020-04-18 15:02
     */
    public boolean set(String key,String value){
        try {
             jedis.set(key,value);
             return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param key
     * @param object
     * @desc: 新增redis 对象
     * @author: tanhao
     * @date: 2020-04-18 15:04
     */
    public boolean set(String key,Object object){
        try {
            jedis.set(key,JSONUtil.toJsonStr(object));
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param key
     * @param object
     * @param time
     * @desc: 添加对象类型的redis并设置时间
     * @author: tanhao
     * @date: 2020-04-18 15:06
     */
    public boolean set(String key,Object object,int time){
        try {
            jedis.set(key,JSONUtil.toJsonStr(object));
            jedis.expire(key,time);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param key
     * @param value
     * @param time
     * @desc: 添加字符类型的数据并设置过期时间
     * @author: tanhao
     * @date: 2020-04-18 15:09
     */
    public boolean set(String key,String value,int time){
        try {
            jedis.set(key,value);
            jedis.expire(key,time);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param key
     * @param map
     * @desc: 存入MAP<String,String>类型的数据
     * @author: tanhao
     * @date: 2020-04-18 15:12
     */
    public boolean hmset(String key, Map<String,String> map){
        try {
            jedis.hmset(key,map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param key
     * @param map
     * @desc: 存入MAP<String,String>类型的数据 并设置过期时间
     * @author: tanhao
     * @date: 2020-04-18 15:12
     */
    public boolean hmset(String key, Map<String,String> map,int time){
        try {
            jedis.hmset(key,map);
            jedis.expire(key,time);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param key
     * @desc: 获取redis 字符类型缓存
     * @author: tanhao
     * @date: 2020-04-18 15:32
     */
    public String get(String key){
        return jedis.get(key);
    }

    /**
     * @param key
     * @desc: 获取redis 对象类型数据
     * @author: tanhao
     * @date: 2020-04-18 15:33
     */
    public Object getObj(String key){
       return JSONUtil.parseObj(jedis.get(key));
    }

    /**
     * @param key redis key
     * @param mKey map key
     * @desc: 根据map key 获取 数据
     * @author: tanhao
     * @date: 2020-04-18 15:36
     */
    public List<String> hmGet(String key, String mKey){
        return jedis.hmget(key,mKey);
    }

}
