package com.lanny.learning.jpa.jpademo;

import com.lanny.learning.jpa.entity.both121.CEO;
import com.lanny.learning.jpa.entity.both121.Company;
import com.lanny.learning.jpa.repository.CeoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Lanny Yao
 * @date 7/8/2018 1:41 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Both121Test {

    @Autowired
    private CeoRepository ceoRepository;

    @Test
    public void testQuery() {
        ceoRepository.findByCompanyId(1).ifPresent(System.out::println);
    }

    @Test
    public void testSave() {
        CEO ceo = new CEO();
        ceo.setName("ceo");

        Company company = new Company();
        company.setComName("com");

        ceo.setCompany(company);
        company.setCeo(ceo);

        ceoRepository.save(ceo);
    }

}
