package com.lanny.learning.jpa.entity.both121;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "JPA_CEO")
@Entity
@Getter
@Setter
@NoArgsConstructor
//@NamedQuery(name = "CEO.findByCompanyId", query = "select c from CEO c where c.company.id = ?1")
public class CEO {

    @Id
    @Column(name = "CEO_ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "CEO_NAME")
    private String name;

    /**
     * 1-1关联关系需要添加unique， 生成外键
     */
    @JoinColumn(name = "COMPANY_ID", unique = true)
    @OneToOne(cascade = CascadeType.PERSIST)
    private Company company;

    @Override
    @Transient
    public String toString() {
        return "This is " + name + " - the ceo in " + company.getComName();
    }

}
