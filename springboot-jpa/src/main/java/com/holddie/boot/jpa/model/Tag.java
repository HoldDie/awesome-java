package com.holddie.boot.jpa.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/4 11:28
 */
@Entity
@Data
public class Tag {

    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToMany(mappedBy = "BlogTagRelation")
    private List<Blog> blogs = new ArrayList<>();
}
