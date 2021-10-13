package com.luch.repository;

import com.luch.pojo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author luch
 * @date 2021/10/10 16:02
 */


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
