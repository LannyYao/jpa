package com.lanny.learning.jpa.entity.inherit.joined;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lanny Yao
 * @date 7/8/2018 3:45 PM
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "T_DOG")
@PrimaryKeyJoinColumn(name = "DOG_ID")
public class Dog extends Animal {

    private Integer legs;

    @Override
    public String toString() {
        return "Dog( " + super.getId() + "," + super.getName() + "," + super.getColor() + "," + legs
                + ")";
    }
}
