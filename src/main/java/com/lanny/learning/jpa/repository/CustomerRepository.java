package com.lanny.learning.jpa.repository;

import com.lanny.learning.jpa.entity.singlen21.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lanny Yao
 * @date 6/9/2018 9:46 AM
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
