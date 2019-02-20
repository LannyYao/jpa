package com.lanny.learning.jpa.repository;

import com.lanny.learning.jpa.entity.entityGraph.Account;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lanny Yao
 * @date 7/10/2018 5:21 PM
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

    //通过@EntityGraph来指定Account类中定义的NamedEntityGraph
    @EntityGraph(value = "account.all", type = EntityGraphType.FETCH)
    Account findOneByUsername(String username);
}
