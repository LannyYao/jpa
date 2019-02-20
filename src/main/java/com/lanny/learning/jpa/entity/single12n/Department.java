package com.lanny.learning.jpa.entity.single12n;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Lanny Yao
 * @date 6/8/2018 9:05 AM
 */
@Entity
@Getter
@Setter
@Table(name = "JPA_DEPARTMENT")
public class Department {

    @Id
    @Column(name = "DEP_ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;

    private String description;

    /**
     * 默认情况下，若删除1的一端，则会先把关联的n的一端的外键置空，然后删除，可以通过 cascade ：设置级联操作
     */
    @JoinColumn(name = "DEP_ID")
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Employee> employees;

    @Override
    @Transient
    public String toString() {
        return departmentName + ": " + description;
    }

}
