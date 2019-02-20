package com.lanny.learning.jpa.entity.inherit.table_per_class;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lanny Yao
 * @date 7/8/2018 3:51 PM
 */
@Entity
@Table(name = "T_CAR")
@Setter
@Getter
@NoArgsConstructor
public class Car extends Vehicle {

    private String engine;

    @Override
    public String toString() {
        return "Car(" + super.getId() + "," + super.getSpeed() + "," + engine + ")";
    }
}
