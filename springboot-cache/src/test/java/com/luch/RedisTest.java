package com.luch;

import com.luch.pojo.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author luch
 * @date 2021/10/10 16:09
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void findAll() {
        Customer customer = new Customer();
        customer.setCustId(3L);
        customer.setCustName("lkkl");
        redisTemplate.opsForValue().set("k1",customer);
    }

}
