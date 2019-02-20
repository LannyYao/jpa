package com.lanny.learning.jpa.jpademo;

import com.lanny.learning.jpa.entity.both12n.Teacher;
import com.lanny.learning.jpa.entity.embedded_key.Address;
import com.lanny.learning.jpa.repository.TeacherRepository;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Lanny Yao
 * @date 7/8/2018 12:39 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Both12NTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void init() {
        // init table
    }

    @Test
    public void testBoth12N() {
        Set<String> phoneNumbers = new HashSet<>();
        phoneNumbers.add("+91-9999999999");
        phoneNumbers.add("+91-9898989898");

        Set<Address> addresses = new HashSet<>();
        addresses.add(new Address("747", "Xixin Road", "Chengdu", "Sichuang", "China",
                "610000"));
        addresses.add(new Address("123", "Dongxin Road", "Nanchuan", "Chongqing", "China",
                "408400"));

        Teacher teacher = new Teacher("Tom", "tom@siemens.com",
                phoneNumbers, addresses);

        teacherRepository.save(teacher);
        teacherRepository.findAll().forEach(System.out::println);
    }

}
