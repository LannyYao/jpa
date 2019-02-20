package com.lanny.learning.jpa.entity.inherit.joined;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Lanny Yao
 * @date 7/8/2018 3:42 PM
 */
@Entity
@Table(name = "T_ANIMAL")
@NoArgsConstructor
@Getter
@Setter
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String color;

}
