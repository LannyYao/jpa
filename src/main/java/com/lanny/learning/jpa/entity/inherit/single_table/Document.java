package com.lanny.learning.jpa.entity.inherit.single_table;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Lanny Yao
 * @date 7/8/2018 3:34 PM
 */
@Entity
@NoArgsConstructor
@Setter
@ToString
@DiscriminatorValue("Document") //父类实体辨别字段列值
public class Document extends WindowFile {

    private Integer size;
}
