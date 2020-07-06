package com.mars.example.vuespring.controller;

import com.mars.example.vuespring.entity.Article;
import com.mars.example.vuespring.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleHandler {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/findAll/{page}/{size}")
    private Page<Article> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Article> result = articleRepository.findAll(pageable);
        return result;
    }

    @GetMapping("/ArticleFindById/{id}")
    private Article findById(@PathVariable("id") Integer id){
        return articleRepository.findById(id).get();
    }

    @PostMapping("/save")
    private String save(@RequestBody Article article){
        Article res = articleRepository.save(article);
        if (res != null){
            return "success";
        }else return "failure";
    }

    @GetMapping("/delete/{id}")
    private String del(@PathVariable ("id") Integer id){
        articleRepository.deleteById(id);
        return "success";
    }
}
