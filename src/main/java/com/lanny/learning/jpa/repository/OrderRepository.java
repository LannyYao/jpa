package com.lanny.learning.jpa.repository;

import com.lanny.learning.jpa.entity.singlen21.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lanny Yao
 * @date 6/9/2018 10:28 AM
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
