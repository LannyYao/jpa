package com.lanny.learning.jpa.entity.bothn21;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @author Lanny Yao
 * @date 6/9/2018 11:36 AM
 */
@Entity
@Getter
@Setter
@Table(name = "asset")
@NoArgsConstructor
public class JpaAsset {

    @Id
    @Column(name = "ASSET_ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "ASSET_NAME")
    private String name;

    /**
     * 注意，若在@OneToMany的一端中使用mappedBy属性，则@OneToMany端就不能够使用JoinColumn
     */
    //    @JoinColumn(name = "ASSET_ID")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "asset")
    private Set<JpaAspect> aspects = new HashSet<>();

    @Override
    @Transient
    public String toString() {
        return "asset: " + name;
    }

}
