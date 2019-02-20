package com.lanny.learning.jpa.entity.entityGraph;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Setter;

/**
 * @author Lanny Yao
 * @date 7/10/2018 5:20 PM
 */
@Table
@Entity
@Setter
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "student")
    private Account account;

    @Override
    public String toString() {
        return "student " + id;
    }

}
