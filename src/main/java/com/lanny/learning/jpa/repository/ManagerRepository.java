package com.lanny.learning.jpa.repository;

import com.lanny.learning.jpa.entity.embedded_PK.Manager;
import com.lanny.learning.jpa.entity.embedded_PK.ManagerIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lanny Yao
 * @date 6/30/2018 5:37 PM
 */
@Repository
public interface ManagerRepository extends JpaRepository<Manager, ManagerIdentity> {

}
