package com.lanny.learning.jpa.entity.singlen21;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Lanny Yao
 * @date 6/9/2018 9:14 AM
 */

@Entity
@Getter
@Setter
@Table(name = "JPA_CUSTOMERS")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String address;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_TIME", length = 50, nullable = false)
    private Date createdTime;

    @Temporal(TemporalType.DATE)
    private Date birth;

    @Override
    @Transient
    public String toString() {

        return String.format("I'm %s and live in %s", name, address);
    }

}
