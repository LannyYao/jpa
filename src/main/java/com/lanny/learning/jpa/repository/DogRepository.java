package com.lanny.learning.jpa.repository;

import com.lanny.learning.jpa.entity.inherit.joined.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lanny Yao
 * @date 7/8/2018 4:34 PM
 */
@Repository
public interface DogRepository extends JpaRepository<Dog, Integer> {

}
