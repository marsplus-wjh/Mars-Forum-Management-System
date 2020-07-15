package com.mars.example.vuespring.repository;

import com.mars.example.vuespring.entity.Article;
import com.mars.example.vuespring.entity.ArticleVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    Article findByTitle(String title);

    @Query(value = "select "
}
