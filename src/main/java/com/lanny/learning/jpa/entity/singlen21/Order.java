package com.lanny.learning.jpa.entity.singlen21;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lanny Yao
 * @date 6/9/2018 10:08 AM
 */
@Getter
@Setter
@Entity
@Table(name = "JPA_ORDER")
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "ORDER_NAME")
    private String orderName;

    /**
     * 映射单向n-1的关联关系
     *
     * @ManyToOne 来映射多对一的关联关系
     * @JoinColumn 来映射外键
     */
    @JoinColumn(name = "CUSTOMER_ID")
    @ManyToOne
    private Customer customer;

    public Order(String orderName, Customer customer) {
        this.orderName = orderName;
        this.customer = customer;
    }

    @Override
    @Transient
    public String toString() {
        return "order name: " + orderName;
    }

}
