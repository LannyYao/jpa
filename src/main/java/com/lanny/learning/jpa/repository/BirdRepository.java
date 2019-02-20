package com.lanny.learning.jpa.repository;

import com.lanny.learning.jpa.entity.inherit.joined.Bird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lanny Yao
 * @date 7/8/2018 4:33 PM
 */
@Repository
public interface BirdRepository extends JpaRepository<Bird, Integer> {

}
