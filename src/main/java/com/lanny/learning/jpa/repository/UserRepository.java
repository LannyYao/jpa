package com.lanny.learning.jpa.repository;

import com.lanny.learning.jpa.entity.embedded_key.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lanny Yao
 * @date 7/7/2018 2:43 PM
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
