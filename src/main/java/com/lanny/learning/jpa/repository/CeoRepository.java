package com.lanny.learning.jpa.repository;

import com.lanny.learning.jpa.entity.both121.CEO;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Lanny Yao
 * @date 6/9/2018 2:19 PM
 */
@Repository
public interface CeoRepository extends JpaRepository<CEO, Integer> {

    @Query("select c from CEO c where c.company.id = ?1")
    Optional<CEO> findByCompanyId(Integer companyId);
}
