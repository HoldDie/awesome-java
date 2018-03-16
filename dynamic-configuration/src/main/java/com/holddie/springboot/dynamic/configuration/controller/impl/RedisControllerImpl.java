package com.holddie.springboot.dynamic.configuration.controller.impl;

import com.holddie.springboot.dynamic.configuration.controller.RedisController;
import com.holddie.springboot.dynamic.configuration.entitiy.Person;
import com.holddie.springboot.dynamic.configuration.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/15 8:15
 */
@RestController
public class RedisControllerImpl implements RedisController {
    @Autowired
    RedisService redisService;


    @RequestMapping("/put")
    public Person put(Person person) {
        return redisService.save(person);
    }


    @RequestMapping("/able")
    public Person cacheable(Person person) {
        return redisService.findOne(person);
    }

    @RequestMapping("/evit")
    public String evit(Long id) {
        redisService.remove(id);
        return "ok";
    }
}
