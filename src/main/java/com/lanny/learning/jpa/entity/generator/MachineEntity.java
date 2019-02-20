package com.lanny.learning.jpa.entity.generator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author Lanny Yao
 * @date 7/10/2018 9:23 AM
 */

@Entity
@Table(name = "machine")
@NoArgsConstructor
@ToString
@Setter
public class MachineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(length = 128)
    private String name;

}
