package com.lanny.learning.jpa.repository;

import com.lanny.learning.jpa.entity.single12n.Department;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lanny Yao
 * @date 6/8/2018 9:17 AM
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Optional<Department> findFirstByDepartmentName(String name);

}
