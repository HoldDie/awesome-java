package com.holddie.springboot.dynamic.configuration.mapper;

import com.holddie.springboot.dynamic.configuration.entitiy.RedisConfig;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Redis Mapper
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/15 7:48
 */
@Repository
public interface RedisConfigMapper {

    /**
     * 获取Redis的配置信息
     * @return List<RedisConfig>
     * @author HoldDie
     * @email holddie@163.com
     * @date 2018/3/15 7:49
     */
    List<RedisConfig> getRedisConfig();
}
