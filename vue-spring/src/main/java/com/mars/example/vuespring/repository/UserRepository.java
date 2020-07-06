package com.mars.example.vuespring.repository;

import com.mars.example.vuespring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT a.id, a.title, a.created_time, u.name FROM User as u inner join Article as a on a.author_id = u.id WHERE a.author_id = u.id")
    public Object[] findAuthorNameById(@Param("author_id") Integer author_id);
}
