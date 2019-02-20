package com.lanny.learning.jpa.entity.embedded_key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Lanny Yao
 * @date 7/7/2018 2:37 PM
 */
@Embeddable
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Column(length = 100, nullable = false)
    private String addressLine1;

    @Column(length = 100, nullable = false)
    private String addressLine2;

    @Column(length = 100, nullable = false)
    private String city;

    @Column(length = 100, nullable = false)
    private String state;

    @Column(length = 100, nullable = false)
    private String country;

    @Column(length = 100, nullable = false)
    private String zipCode;

}
