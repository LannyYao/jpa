package com.lanny.learning.jpa.entity.inherit.table_per_class;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lanny Yao
 * @date 7/8/2018 4:59 PM
 */
@Entity
@Table(name = "T_BUS")
@Setter
@Getter
@NoArgsConstructor
public class Bus extends Vehicle {

    private Integer capacity;

    @Override
    public String toString() {
        return "Bus(" + super.getId() + "," + super.getSpeed() + "," + capacity + ")";
    }

}
