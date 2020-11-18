package com.holddie.boot.jpa.dao;

import com.holddie.boot.jpa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/4 14:44
 */
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer customer = new Customer();
}
