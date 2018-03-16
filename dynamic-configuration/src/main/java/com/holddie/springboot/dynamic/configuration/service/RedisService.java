package com.holddie.springboot.dynamic.configuration.service;

import com.holddie.springboot.dynamic.configuration.entitiy.Person;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/15 8:02
 */
public interface RedisService {

    Person save(Person person);

    void remove(Long id);

    Person findOne(Person person);
}
