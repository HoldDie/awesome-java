package com.holddie.boot.jpa.dao;

import com.holddie.boot.jpa.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/1 22:07
 */
public interface UserRepository extends CrudRepository<User,Long> {

    List<User> findByName(String name);

    List<User> findByEmailAndName(String email, String name);
}
