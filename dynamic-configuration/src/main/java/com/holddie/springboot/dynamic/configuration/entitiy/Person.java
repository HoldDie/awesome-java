package com.holddie.springboot.dynamic.configuration.entitiy;

/**
 * person
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/15 7:46
 */
public class Person {

    private Long id;

    private String name;

    private Integer age;

    private String address;

    public Person() {
    }

    public Person(Long id, String name, Integer age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
