package org.precondition.limit;

/**
 * .
 * User: jiawei.gao
 * Date: 14-8-10
 * qunar.com
 */
public interface Limiter {
    public Integer currentValue(String key);

    public void incrementCurrentValue(String key , long duringSecs);

    public Integer currentLimit(String key);


}
