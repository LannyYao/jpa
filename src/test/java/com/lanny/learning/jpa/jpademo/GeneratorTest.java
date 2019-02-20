package com.lanny.learning.jpa.jpademo;

import com.lanny.learning.jpa.entity.generator.MachineEntity;
import com.lanny.learning.jpa.repository.MachineRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Lanny Yao
 * @date 7/10/2018 9:25 AM
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GeneratorTest {

    @Autowired
    private MachineRepository machineRepository;

    @Test
    public void testUUIDGenerator() {

        MachineEntity machineEntity = new MachineEntity();
        machineEntity.setName("machine-test");

        System.out.println(machineRepository.save(machineEntity));

    }
}
