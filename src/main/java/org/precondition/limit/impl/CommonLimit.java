package org.precondition.limit.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.precondition.limit.Limiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

/**
 * .
 * User: jiawei.gao
 * Date: 14-8-10
 * qunar.com
 */
public class CommonLimit implements Limiter{
    Logger logger = LoggerFactory.getLogger(CommonLimit.class);
    private Jedis jedis;

    public  CommonLimit(){
        jedis = new Jedis("127.0.0.1",6379);
    }

    @Override public Integer currentValue(String key) {
        logger.info("redis get key={}",key);
        String value = jedis.get(key);
        return StringUtils.isNotBlank(value)? NumberUtils.toInt(value) : 0;
    }

    @Override public void incrementCurrentValue(String key, long duringSecs) {
        Long value = jedis.incr(key);
        if (Long.valueOf(1).equals(value)){
            jedis.expire(key,(int)duringSecs);
        }
    }

    @Override public Integer currentLimit(String key) {
        logger.info("redis get key={}",key);
        String value = jedis.get(key);
        return StringUtils.isNotBlank(value)? NumberUtils.toInt(value) : 0;
    }
}
