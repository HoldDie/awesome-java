package com.holddie.spring.dynamic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/19 11:53
 */
@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("test")
    public String test(){
        return "123";
    }
}
