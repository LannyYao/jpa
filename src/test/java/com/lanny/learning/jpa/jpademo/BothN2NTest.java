package com.lanny.learning.jpa.jpademo;

import com.lanny.learning.jpa.entity.bothn2n.Category;
import com.lanny.learning.jpa.entity.bothn2n.Product;
import com.lanny.learning.jpa.repository.CategoryRepository;
import com.lanny.learning.jpa.repository.ProductRepository;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Lanny Yao
 * @date 7/7/2018 2:19 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BothN2NTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void init() {
        // init table
    }

    @Test
//    @Transactional
    public void testBothManyToManyFind() {
        List<Product> products = productRepository.findAll();
        products.forEach(System.out::println);
        // product1: {category1 category2}
        // product2: {category1 category2}

        List<Category> categories = categoryRepository.findAll();
        categories.forEach(System.out::println);
        // category1: {product1 product2}
        // category2: {product1 product2}
    }

    /**
     * 双向多对多关系，先保存不声明中间表的一方，后保存声明中间表的一方
     */
    @Test
    public void testBothManyToManyPersist() {

        Category category1 = new Category();
        category1.setName("category1");
        Category category2 = new Category();
        category2.setName("category2");

        Product product1 = new Product();
        product1.setName("product1");
        Product product2 = new Product();
        product2.setName("product2");

        category1.getProducts().add(product1);
        category1.getProducts().add(product2);
        category2.getProducts().add(product1);
        category2.getProducts().add(product2);

        product1.getCategories().add(category1);
        product1.getCategories().add(category2);
        product2.getCategories().add(category1);
        product2.getCategories().add(category2);

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        productRepository.save(product1);
        productRepository.save(product2);
    }

}
