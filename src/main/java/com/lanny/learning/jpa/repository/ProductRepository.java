package com.lanny.learning.jpa.repository;

import com.lanny.learning.jpa.entity.bothn2n.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
