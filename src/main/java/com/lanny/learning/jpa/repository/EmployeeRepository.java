package com.lanny.learning.jpa.repository;

import com.lanny.learning.jpa.entity.single12n.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
