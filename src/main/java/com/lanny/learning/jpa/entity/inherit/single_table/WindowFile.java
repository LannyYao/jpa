package com.lanny.learning.jpa.entity.inherit.single_table;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
 * @date 7/8/2018 3:28 PM
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "WINDOW_FILE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DISCRIMINATOR", discriminatorType = DiscriminatorType.STRING, length
        = 30) // 辨别字段列名
@DiscriminatorValue("WindowFile") //父类实体辨别字段列值
public class WindowFile {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "DATE")
    private Date date;
}
