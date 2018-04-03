package com.holddie.boot.jpa.dao.projection;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/3 11:20
 */
public class NameOnlyDto {
    private final String firstname, lastname;

    public NameOnlyDto(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
