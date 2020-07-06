package com.mars.example.vuespring.repository;

import com.mars.example.vuespring.entity.Article;
import com.mars.example.vuespring.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleRepositoryTest {
    @Autowired
    private ArticleRepository articleRepository;
    private UserRepository userRepository;

    @Test
    void findAll(){
        //System.out.println(articleRepository.findAll());
        System.out.println();
    }

    @Test
    void save(){
        Article article = new Article();
        article.setAuthor_id(1);
        article.setTitle("TestAdd");
        article.setContent("fsadfasdfas");
        Article result = articleRepository.save(article);
        System.out.println(result);
    }

    @Test
    void modify(){
        Article article = new Article();
        article.setId(178);
        article.setAuthor_id(1);
        article.setTitle("TestAdd11");
        article.setContent("fsadfasdfas");
        Article result = articleRepository.save(article);
        System.out.println(result);
    }

    @Test
    void findById(){
        Integer articleId = 178;
        Article article = articleRepository.findById(articleId).get();
        System.out.println(article);
    }

//    @Test
//    void findArticePlusUser(){
//        Integer articleId = 178;
//        Article article = articleRepository.findById(articleId).get();
//        System.out.println(article);
//        User user = userRepository.findById(article.getAuthor_id()).get();
//        sout
//    }
}