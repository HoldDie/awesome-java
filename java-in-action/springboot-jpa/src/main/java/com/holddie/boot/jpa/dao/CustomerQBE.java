package com.holddie.boot.jpa.dao;

import com.holddie.boot.jpa.model.Customer;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/4 14:47
 */
public class CustomerQBE {

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setName("Jack");
        customer.setAddress("上海");
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith())
                .withIgnorePaths("focus");
        Example<Customer> ex = Example.of(customer,matcher);

    }
}
