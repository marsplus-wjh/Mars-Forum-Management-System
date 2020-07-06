package com.mars.example.vuespring.controller;

import com.mars.example.vuespring.entity.User;
import com.mars.example.vuespring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<User> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Pageable pageable = PageRequest.of(page-1, size);
        return userRepository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody User user){
        User result = userRepository.save(user);
        if (result != null){
            return "success";
        }else return "false";
    }

    @GetMapping("/UserFindById/{id}")
    public User UserFindById(@PathVariable("id") Integer id){
        User result = userRepository.findById(id).get();
            return result;
    }

    @PostMapping("/delete/{id}")
    public String UserDelete(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
        return "success";
    }
}
