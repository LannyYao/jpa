package com.lanny.learning.jpa.entity.inherit.table_per_class;

import javax.persistence.Entity;
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
 * @date 7/8/2018 3:49 PM
 */
@Setter
@NoArgsConstructor
@Entity
@ToString
@Getter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "T_VEHICLE")
public class Vehicle {

    @Id
    private Integer id;

    private Integer speed;
}
