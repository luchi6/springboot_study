package com.luch;

import com.luch.pojo.Address;
import com.luch.pojo.Person;
import com.luch.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author luch
 * @date 2021/10/10 23:35
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void savePerson() {
        Person person = new Person();
        person.setFirstname("张");
        person.setLastname("三");

        Address address = new Address();
        address.setCity("北京");
        address.setCountry("中国");
        person.setAddress(address);

        personRepository.save(person);
    }

    @Test
    public void selectPerson() {
//        List<Person> list = personRepository.findByAddress_city("北京");
        List<Person> list = personRepository.findByAddress_country("中国");
//        List<Person> list = personRepository.findByFirstname("张");

        list.forEach(System.out::println);
    }
}
