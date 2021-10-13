package com.luch;

import com.luch.pojo.Customer;
import com.luch.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author luch
 * @date 2021/10/10 16:09
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void findAll() {
        List<Customer> all = customerRepository.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void update() {
        customerRepository.updateCustomer("虎牙", 1L);
    }
}
