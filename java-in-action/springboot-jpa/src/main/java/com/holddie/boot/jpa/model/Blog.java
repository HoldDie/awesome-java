package com.holddie.boot.jpa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/4 11:26
 */
@Entity
@Data
public class Blog {

    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "blog_tag_relation",
            joinColumns = @JoinColumn(name = "blog_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id",referencedColumnName = "id")
    )
    private List<Tag> tags = new ArrayList<Tag>();

}
