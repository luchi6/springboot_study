package com.luch.repository;

import com.luch.pojo.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author luch
 * @date 2021/10/10 23:32
 */


public interface PersonRepository extends CrudRepository<Person,String> {

    List<Person> findByAddress_city(String name);
    List<Person> findByAddress_country(String name);
    List<Person> findByFirstname(String name);
}
