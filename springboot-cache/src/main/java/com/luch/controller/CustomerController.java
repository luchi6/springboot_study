package com.luch.controller;

import com.luch.pojo.Customer;
import com.luch.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author luch
 * @date 2021/10/11 0:22
 */

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/findAll")
    @Cacheable("customer")
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/findById")
    public Customer findById(@RequestParam("id") Long id) {
        return customerService.findById(id);
    }

    @RequestMapping("update")
    public void update(@RequestParam("custName") String custName, @RequestParam("id") Long id) {
        customerService.update(custName, id);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") Long id) {
        customerService.delete(id);
    }
}
