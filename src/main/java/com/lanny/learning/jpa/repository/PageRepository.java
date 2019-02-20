package com.lanny.learning.jpa.repository;

import com.lanny.learning.jpa.entity.entityGraph.Page;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lanny Yao
 * @date 7/10/2018 5:50 PM
 */
public interface PageRepository extends JpaRepository<Page, Long> {

}
