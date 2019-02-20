package com.lanny.learning.jpa.entity.inherit.single_table;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Lanny Yao
 * @date 7/8/2018 3:33 PM
 */
@Entity
@NoArgsConstructor
@Setter
@ToString
@DiscriminatorValue("Folder") //父类实体辨别字段列值
public class Folder extends WindowFile {

    private Integer fileCount;
}
