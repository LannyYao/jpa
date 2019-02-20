package com.lanny.learning.jpa.jpademo;

import com.lanny.learning.jpa.entity.singlen21.Customer;
import com.lanny.learning.jpa.entity.singlen21.Order;
import com.lanny.learning.jpa.repository.CustomerRepository;
import com.lanny.learning.jpa.repository.OrderRepository;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Lanny Yao
 * @date 7/7/2018 1:59 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SingleN21Test {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    private String[] addresses = new String[]{"西安", "北京", "郑州", "上海", "武汉", "长沙", "广州", "贵阳", "柳州",
            "咸阳", "蓝田", "渭南"};
    private String[] names1 = new String[]{"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈"};
    private String[] names2 = new String[]{"强", "亚", "哲", "凡", "路", "举", "昕", "科", "武", "田"};
    private Random random = new Random();

    @Test
    public void init() {
        // init table
    }

    @Test
    public void testSingleCreate() {

        for (int i = 0; i < 5; i++) {
            String cName =
                    names1[random.nextInt(names1.length)] + names2[random.nextInt(names2.length)];
            String cAddress = addresses[random.nextInt(addresses.length)];

            Customer customer = new Customer();
            customer.setAddress(cAddress);
            customer.setBirth(new Date());
            customer.setCreatedTime(new Date());
            customer.setName(cName);

            customerRepository.save(customer);
        }
    }

    @Test
    public void testSingleManyToOneFind() {
        List<Order> orders = orderRepository.findAll();
        System.out.println("print order: ");
        orders.forEach(System.out::println);
        System.out.println("print customer: ");
        orders.stream().map(Order::getCustomer).collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /**
     * 保存多对一时，建议先保存1的一端，后保存n的一端，这样不会多出额外的UPDATE语句
     */
    @Test
    public void testSingleManyToOnePersist() {

        String cName =
                names1[random.nextInt(names1.length)] + names2[random.nextInt(names2.length)];
        String cAddress = addresses[random.nextInt(addresses.length)];

        Customer customer = new Customer();
        customer.setAddress(cAddress);
        customer.setBirth(new Date());
        customer.setCreatedTime(new Date());
        customer.setName(cName);

        customerRepository.save(customer);

        Stream.of("order-1", "order-2").map(s -> new Order(s, customer))
                .forEach(orderRepository::save);
    }

}
