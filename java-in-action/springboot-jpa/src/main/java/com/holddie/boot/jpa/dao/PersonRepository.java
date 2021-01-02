package com.holddie.boot.jpa.dao;

import com.holddie.boot.jpa.dao.projection.NameOnly;
import com.holddie.boot.jpa.dao.projection.NameOnlyDto;
import com.holddie.boot.jpa.model.Person;
import org.springframework.data.repository.Repository;

import java.util.Collection;
import java.util.UUID;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/3 11:00
 */
public interface PersonRepository extends Repository<Person, UUID> {
    Collection<NameOnly> findByLastname(String lastname);

    Collection<NameOnlyDto> findByLastname(String lastname, Class type);
}
