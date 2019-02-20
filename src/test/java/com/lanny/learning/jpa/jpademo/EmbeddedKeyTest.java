package com.lanny.learning.jpa.jpademo;

import com.lanny.learning.jpa.entity.embedded_key.Address;
import com.lanny.learning.jpa.entity.embedded_key.Name;
import com.lanny.learning.jpa.entity.embedded_key.User;
import com.lanny.learning.jpa.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Lanny Yao
 * @date 7/7/2018 2:48 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmbeddedKeyTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void init() {
        // init table
    }

    @Test
    public void testEmbeddedKey() {
        Name name = new Name("lang", "lanny", "yao");
        Address address = new Address("747", "Xixin Road", "Chengdu", "Sichuang", "China",
                "610000");
        User user = new User(name, "lang.yao@siemens.com", address);

        userRepository.save(user);
    }

}
