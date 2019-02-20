package com.lanny.learning.jpa.jpademo;

import com.lanny.learning.jpa.entity.entityGraph.Account;
import com.lanny.learning.jpa.entity.entityGraph.Page;
import com.lanny.learning.jpa.entity.entityGraph.Role;
import com.lanny.learning.jpa.entity.entityGraph.Student;
import com.lanny.learning.jpa.repository.AccountRepository;
import com.lanny.learning.jpa.repository.PageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Lanny Yao
 * @date 7/10/2018 5:25 PM
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class EntityGraphTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PageRepository pageRepository;

    @Test
    public void testSave() {
        Student student = new Student();

        Page page = new Page();
        page.setDescription("test-page");
        page.setPageName("page-name");
        page.setUrl("localhost:8080/test");

        Role role = new Role();
        role.setName("test-role");

        Account account = new Account();
        account.setPassword("test-pwd");
        account.setUsername("test-username");
        account.getRoles().add(role);
        account.setStudent(student);

        student.setAccount(account);
        role.getAccounts().add(account);

        role.getPages().add(page);
        page.getRoles().add(role);

        accountRepository.save(account);
//        pageRepository.save(page);
    }

    @Test
    public void testFind() {

        Account account = accountRepository.findOneByUsername("test-username");
        System.out.println(account);
    }
}
