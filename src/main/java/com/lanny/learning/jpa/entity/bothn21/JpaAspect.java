package com.lanny.learning.jpa.entity.bothn21;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lanny Yao
 * @date 6/9/2018 11:37 AM
 */
@Getter
@Setter
@Entity
@Table(name = "aspect")
@NoArgsConstructor
public class JpaAspect {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "ASPECT_NAME")
    private String name;

    @JoinColumn(name = "ASSET_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private JpaAsset asset;

    @Override
    @Transient
    public String toString() {
        return "aspect: " + name;
    }

}
