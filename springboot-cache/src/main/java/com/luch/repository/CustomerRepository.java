package com.luch.repository;

import com.luch.pojo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author luch
 * @date 2021/10/10 16:02
 */


public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Transactional
    @Modifying
    @Query(value = "update cst_customer c set c.cust_name = ?1 where cust_id = ?2", nativeQuery = true)
    int updateCustomer(String custName, Long id);
}
