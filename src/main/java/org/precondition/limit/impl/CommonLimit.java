package org.precondition.limit.impl;

import com.google.common.base.Preconditions;
import com.google.common.io.Resources;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.precondition.limit.Limiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.Properties;

/**
 * .
 * User: jiawei.gao
 * Date: 14-8-10
 * qunar.com
 */
public class CommonLimit implements Limiter{
    Logger logger = LoggerFactory.getLogger(CommonLimit.class);
    private Jedis jedis;

    private Properties properties ;

    public  CommonLimit() {
        jedis = new Jedis("127.0.0.1",6379);
        properties = new Properties();
        try {
            properties.load(Resources.asByteSource(Resources.getResource("limit.properties")).openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override public Integer currentValue(String key) {
        logger.info("redis get key={}",key);
        String value = jedis.get(key);
        return StringUtils.isNotBlank(value)? NumberUtils.toInt(value) : 0;
    }

    @Override public void incrementCurrentValue(String key, long duringSecs) {
        logger.info("redis incr key={}",key);
        Long value = jedis.incr(key);
        if (Long.valueOf(1).equals(value)){
            jedis.expire(key,(int)duringSecs);
        }
    }

    @Override public Integer currentLimit(String key) {
        logger.info("limit key={}",key);
        String property = properties.getProperty(key);
        Preconditions.checkArgument(property!=null,"limit key is null "+key );
        return NumberUtils.toInt(property);
    }
}
