package com.lanny.learning.jpa.repository;

import com.lanny.learning.jpa.entity.inherit.single_table.WindowFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lanny Yao
 * @date 7/8/2018 4:11 PM
 */
@Repository
public interface WindowFileRepository extends JpaRepository<WindowFile, Integer> {

}
