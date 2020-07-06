package com.mars.example.vuespring.repository;

import com.mars.example.vuespring.entity.User;
import com.sun.xml.bind.v2.model.core.ID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findAll(){
        System.out.println(userRepository.findAll());
    }

    @Test
    void save(){
        User user = new User();
        user.setName("MarsTest");
        user.setEmail("marstest@gmail.com");
        user.setPasswd("123");
        User re = userRepository.save(user);
        System.out.print(re);
    }

    @Test
    void deleteById(){
        User re = userRepository.findById(0).get();
        System.out.print(re);
    }

}