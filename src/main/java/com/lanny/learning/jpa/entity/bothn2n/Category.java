package com.lanny.learning.jpa.entity.bothn2n;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Table(name = "T_CATEGORY")
@Entity
@Getter
@Setter
public class Category {

    @GeneratedValue
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "categories")
    private List<Product> products = new ArrayList<>();

    @Override
    @Transient
    public String toString() {
        return this.name + ": " + products.stream()
                .map(Product::getName)
                .collect(Collectors.joining(" ", "{", "}"));
    }
}
