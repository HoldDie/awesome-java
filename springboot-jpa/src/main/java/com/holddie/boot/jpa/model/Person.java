package com.holddie.boot.jpa.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/3 10:58
 */
@Entity
@Data
public class Person {
    @Id
    UUID id;

    String firstname, lastname;
    Address address;

    static class Address {
        String zipCode, city, street;
    }
}
