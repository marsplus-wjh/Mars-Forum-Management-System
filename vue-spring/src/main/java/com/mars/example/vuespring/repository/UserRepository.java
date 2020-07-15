package com.mars.example.vuespring.repository;

import com.mars.example.vuespring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
