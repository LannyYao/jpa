package com.lanny.learning.jpa.repository;

import com.lanny.learning.jpa.entity.both121.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lanny Yao
 * @date 6/9/2018 2:22 PM
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
