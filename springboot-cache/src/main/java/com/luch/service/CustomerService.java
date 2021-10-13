package com.luch.service;

import com.luch.pojo.Customer;
import com.luch.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author luch
 * @date 2021/10/12 0:55
 */

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Cacheable(value = "customer", unless = "#result==null")
    public Customer findById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }

    @CachePut(value = "customer", key = "#result.id")
    public void update(String custName, Long id) {
        customerRepository.updateCustomer(custName, id);
    }

    @CacheEvict("customer")
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
