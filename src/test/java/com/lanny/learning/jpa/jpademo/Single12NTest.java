package com.lanny.learning.jpa.jpademo;

import com.lanny.learning.jpa.entity.single12n.Department;
import com.lanny.learning.jpa.entity.single12n.Employee;
import com.lanny.learning.jpa.repository.DepartmentRepository;
import com.lanny.learning.jpa.repository.EmployeeRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Lanny Yao
 * @date 7/7/2018 2:12 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Single12NTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void init() {
        // init table
    }

    /**
     * 默认对关联的多的一方使用懒加载的加载策略
     */
    @Test
    public void testSingleOneToManyFind() {
        List<Department> departments = departmentRepository.findAll();
        System.out.println("print depart: ");
        departments.forEach(System.out::println);

        System.out.println("print employees: ");
        departments.stream().map(Department::getEmployees).map(employees -> {
            employees.forEach(System.out::println);
            return 0;
        }).collect(Collectors.toList());
    }

    /**
     * 单向1-n关联关系执行保存时，一定会多出UPDATE语句， 因为n的一端在插入时不会同时插入外键列 建议先存n端
     */
    @Test
    public void testSingleOneToManyPersist() {

        Department department = new Department();
        department.setDepartmentName("dep-1");
        department.setDescription("Department for test");

        Employee employee1 = new Employee();
        employee1.setAddress("CQ");
        employee1.setAge(18);
        employee1.setName("Tom");

        Employee employee2 = new Employee();
        employee2.setAddress("XA");
        employee2.setAge(18);
        employee2.setName("Mary");

        Set<Employee> employees = new HashSet<>();
        employees.add(employee1);
        employees.add(employee2);

        //建立关联关系
        department.setEmployees(employees);

        //保存
        employeeRepository.save(employees);
        departmentRepository.save(department);
    }

    @Test
    public void testOptional() {
        Optional<Department> department = departmentRepository.findFirstByDepartmentName("dep-1");
        System.out.println(department.orElse(null));
    }

}
