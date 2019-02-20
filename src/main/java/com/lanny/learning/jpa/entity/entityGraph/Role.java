package com.lanny.learning.jpa.entity.entityGraph;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Lanny Yao
 * @date 7/10/2018 5:12 PM
 */
@Entity
@Table(name = "ROLE",
        uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
@Setter
@Getter
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
    private Set<Account> accounts = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "REL_PAGE_ROLE",
            joinColumns = {
                    @JoinColumn(name = "roles", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "pages",
                    referencedColumnName = "id")})
    private Set<Page> pages = new HashSet<>();

    @Override
    public String toString() {
        return "role " + id + ", name " + name;
    }

}
