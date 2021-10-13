package com.luch.pojo;

import org.springframework.data.redis.core.index.Indexed;

/**
 * @author luch
 * @date 2021/10/10 23:29
 */


public class Address {
    @Indexed
    private String city;
    @Indexed
    private String country;

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
