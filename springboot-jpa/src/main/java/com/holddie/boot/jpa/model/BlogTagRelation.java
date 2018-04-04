package com.holddie.boot.jpa.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/4 11:33
 */
@Entity
@Data
public class BlogTagRelation {

    @Column(name = "blog_id")
    private Integer blogId;

    @Column(name = "tag_id")
    private Integer tagId;

}
