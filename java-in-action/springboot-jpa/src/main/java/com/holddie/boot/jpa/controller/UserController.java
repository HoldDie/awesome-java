package com.holddie.boot.jpa.controller;

import com.holddie.boot.jpa.dao.UserRepository;
import com.holddie.boot.jpa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户控制
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/1 22:08
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        Float a                  = 1.0f;
        System.out.println();
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/add")
    public void addUser(@RequestParam String name, @RequestParam String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
    }

    @GetMapping("/all")
    @ResponseBody
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/lastname")
    @ResponseBody
    public Iterable<User> getUsersByLastname(){
        return userRepository.findAll();
    }
}
