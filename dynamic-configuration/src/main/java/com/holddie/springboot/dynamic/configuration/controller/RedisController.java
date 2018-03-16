package com.holddie.springboot.dynamic.configuration.controller;

import com.holddie.springboot.dynamic.configuration.entitiy.Person;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/15 8:14
 */
public interface RedisController {
    @RequestMapping("/put")
    public Person put(Person person);

    @RequestMapping("/able")
    public Person cacheable(Person person);

    @RequestMapping("/evit")
    public String evit(Long id);
}
