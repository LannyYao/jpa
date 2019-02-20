package com.lanny.learning.jpa.repository;

import com.lanny.learning.jpa.entity.inherit.table_per_class.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lanny Yao
 * @date 7/8/2018 4:53 PM
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}
