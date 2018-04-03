package com.holddie.boot.jpa.dao.projection;

import com.holddie.boot.jpa.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/3 11:02
 */
public interface NameOnly {

    String getFirstname();

    String getLastname();

    @Value("#{target.firstname + ' ' + target.lastname}")
    String getFullName();

    @Value("#{@myBean.getFullName(target)}")
    String getFullName1();

    @Value("#{args[0] + ' ' + target.firstname + '!'}")
    String getSalutation(String prefix);

    @Component
    class MyBean {
        private String fullName;

        public String getFullName(Person person) {
            return person.getFirstname() + "-" + person.getLastname();
        }
    }
}
