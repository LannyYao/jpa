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
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Lanny Yao
 * @date 7/10/2018 5:10 PM
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "account")
@NamedEntityGraphs({
        @NamedEntityGraph(name = "account.all",
                attributeNodes = {//attributeNodes 来定义需要懒加载的属性
                        @NamedAttributeNode("student"),//无延伸
                        @NamedAttributeNode(value = "roles",//要懒加载roles属性中的pages元素
                                subgraph = "pages"),
                },
                subgraphs = {//subgraphs 来定义关联对象的属性
                        @NamedSubgraph(name = "pages",//一层延伸
                                attributeNodes = @NamedAttributeNode("pages")),
                        @NamedSubgraph(name = "role",//两层延伸
                                attributeNodes = @NamedAttributeNode(
                                        value = "role",
                                        subgraph = "pages"))})})
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ACCOUNT_STUDENT")
    private Student student;

    @Column
    private String username;

    @Column
    private String password;

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "REL_ACCOUNT_ROLE",
            joinColumns = {@JoinColumn(name = "accounts",
                    referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "roles", referencedColumnName = "id")})
    @OrderBy(value = "id DESC")
    private Set<Role> roles = new HashSet<>();

}
