package com.holddie.springboot.dynamic.configuration.mapper;

import com.holddie.springboot.dynamic.configuration.entitiy.Person;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * 用户查询接口
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/15 7:53
 */
@Repository
public interface PersonMapper {

    void save(Person person);

    Person findOne(Long id);

    void delete(Long id);
}
