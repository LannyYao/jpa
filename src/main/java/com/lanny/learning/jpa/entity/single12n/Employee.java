package com.lanny.learning.jpa.entity.single12n;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "JPA_EMPLOYEE")
public class Employee {

    @Id
    @Column(name = "EMP_ID")
    @GeneratedValue
    private Integer id;

    @Column(length = 100)
    private String name;
    private Integer age;
    private String address;

    @Override
    @Transient
    public String toString() {
        return this.name + " is " + this.age + " and lives in " + this.address;
    }

}
