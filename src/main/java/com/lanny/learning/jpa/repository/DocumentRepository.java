package com.lanny.learning.jpa.repository;

import com.lanny.learning.jpa.entity.inherit.single_table.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lanny Yao
 * @date 7/8/2018 4:15 PM
 */
@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {

}
