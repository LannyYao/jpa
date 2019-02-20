package com.lanny.learning.jpa.repository;

import com.lanny.learning.jpa.entity.bothn2n.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
