package com.holddie.boot.jpa.dao;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

/**
 * 自定义方法 暴露
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/3 8:51
 */
@NoRepositoryBean
public interface MyBaseRepository<T, ID extends Serializable> extends Repository<T, ID> {
    T findOne(ID id);

    T save(T entity);
}
