package com.lanny.learning.jpa.entity.entityGraph;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Lanny Yao
 * @date 7/10/2018 5:16 PM
 */
@Entity
@Table(name = "PAGE_PRIVILEGE")
@Setter
@Getter
public class Page {

    @Id
    @GeneratedValue
    private Long id;

    private String pageName;

    private String url;

    private String description = "";

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "pages")
    private Set<Role> roles = new HashSet<>();

    @Override
    public String toString() {
        return "page " + id + ", name " + pageName + ", url" + url + ", desc " + description;
    }

}
