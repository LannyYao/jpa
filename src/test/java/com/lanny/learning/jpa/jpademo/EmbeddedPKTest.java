package com.lanny.learning.jpa.jpademo;

import com.lanny.learning.jpa.entity.embedded_PK.Manager;
import com.lanny.learning.jpa.entity.embedded_PK.ManagerIdentity;
import com.lanny.learning.jpa.repository.ManagerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Lanny Yao
 * @date 7/7/2018 2:17 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmbeddedPKTest {

    @Autowired
    private ManagerRepository managerRepository;

    @Test
    public void init() {
        // init table
    }

    @Test
    public void testEmbeddedPrimaryKey() {
        Manager manager = new Manager(new ManagerIdentity("111111", "siemens"),
                "Lanny", "111111@siemens.com", "13896564354");

        managerRepository.save(manager);
    }
}
