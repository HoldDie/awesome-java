package com.holddie.boot.jpa.controller;

import com.holddie.boot.jpa.dao.PersonRepository;
import com.holddie.boot.jpa.dao.UserRepository;
import com.holddie.boot.jpa.dao.projection.NameOnlyDto;
import com.holddie.boot.jpa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * 用户控制
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/1 22:08
 */
@Controller
@RequestMapping(value = "/person")
public class PersonController {

    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/lastname")
    @ResponseBody
    public Collection<NameOnlyDto> getUsersByLastname(){
        return personRepository.findByLastname("123", NameOnlyDto.class);
    }
}
