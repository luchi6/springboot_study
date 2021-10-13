package com.luch.service;

import com.luch.pojo.Customer;
import com.luch.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author luch
 * @date 2021/10/12 0:55
 */

@Service
public class ApiCustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Long id) {
        Object o = redisTemplate.opsForValue().get("customer_" + id);
        if (o != null) {
            return (Customer)o;
        }
        Optional<Customer> customer = customerRepository.findById(id);
        customer.ifPresent(c -> redisTemplate.opsForValue().set("customer_" + id,c,1, TimeUnit.DAYS));
        return customer.orElse(null);
    }

    public void update(Customer customer) {
        customerRepository.updateCustomer(customer.getCustName(), customer.getCustId());
        redisTemplate.opsForValue().set("customer_" + customer.getCustId(),customer,1, TimeUnit.DAYS);
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
        redisTemplate.delete("customer_" + id);
    }
}
