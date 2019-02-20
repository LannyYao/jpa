package com.lanny.learning.jpa.entity.bothn2n;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Table(name = "T_PRODUCT")
@Entity
@Getter
@Setter
public class Product {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @JoinTable(name = "PRODUCT_CATEGORY", //中间表名称
            joinColumns = {
                    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")},
            //中间表PRODUCT_ID字段关联PRODUCT的ID
            inverseJoinColumns = {@JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")})
    //中间表CATEGORY_ID字段关联CATEGORY的ID
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH) //在双向的多对多关系中不能设置级联删除
    private List<Category> categories = new ArrayList<>();

    @Override
    @Transient
    public String toString() {
        return this.name + ": " + categories.stream()
                .map(Category::getName)
                .collect(Collectors.joining(" ", "{", "}"));
    }

}
