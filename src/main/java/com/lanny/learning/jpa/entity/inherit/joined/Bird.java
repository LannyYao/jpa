package com.lanny.learning.jpa.entity.inherit.joined;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lanny Yao
 * @date 7/8/2018 3:44 PM
 */
@Entity
@Table(name = "T_BIRD")
@NoArgsConstructor
@Setter
@Getter
@PrimaryKeyJoinColumn(name = "BIRD_ID")
public class Bird extends Animal {

    private Integer speed;

    @Override
    public String toString() {
        return "Bird( " + super.getId() + "," + super.getName() + "," + super.getColor() + ","
                + speed + ")";
    }

}
