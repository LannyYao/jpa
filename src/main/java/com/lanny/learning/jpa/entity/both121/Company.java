package com.lanny.learning.jpa.entity.both121;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lanny Yao
 * @date 6/9/2018 2:11 PM
 */


@Getter
@Entity
@Setter
@NoArgsConstructor
@Table(name = "JPA_COMPANY")
public class Company {

    @Id
    @Column(name = "COMPANY_ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "COMPANY_NAME")
    private String comName;

    /**
     * 对于不要维护关联关系，没有外键的一方，使用@OneToOne来进行映射，需要设置mapped = 『对方表名』
     */
    @OneToOne(fetch = FetchType.LAZY)
    private CEO ceo;

    @Override
    @Transient
    public String toString() {
        return "This company " + comName + " and the ceo is " + ceo.getName();
    }

}
