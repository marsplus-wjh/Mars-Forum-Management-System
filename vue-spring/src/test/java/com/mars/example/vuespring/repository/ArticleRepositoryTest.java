package com.mars.example.vuespring.repository;

import com.mars.example.vuespring.controller.ArticleHandler;
import com.mars.example.vuespring.entity.Article;
import com.mars.example.vuespring.entity.ArticleVO;
import com.mars.example.vuespring.entity.User;
import com.mars.example.vuespring.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class ArticleRepositoryTest {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    protected Mapper dozerMapper;

    //Mock对象，模拟http请求
    private MockMvc mockMvc;
//    @BeforeAll
//    static void setUP(){
//        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleHandler()).build();
//    }

//    @Test
//    public void saveArticle() throws Exception{
//
//        String article = "{\"id\":10,\"title\":\"fsadfasdf\",\"content\":\"vcxzvczx\",\"last_update\":\"2020-07-03 13:35:17\",\"author_id\":5,\"created_time\":\"2020-07-03 13:35:17\"}";
//        MvcResult mvcResult = mockMvc.perform(
//                MockMvcRequestBuilders
//                .request(HttpMethod.POST, "/article/save")
//                .contentType("application/json")
//                .content(article)
//        ).andDo(print())
//        .andReturn();
//        log.info(mvcResult.getResponse().getContentAsString());
//    }

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

    @Test
    void findArticePlusAuthername(){
        Integer articleId = 178;
        Optional<Article> article = articleRepository.findById(articleId);
        System.out.println(article.get());
        User user = userRepository.findById(article.get().getAuthor_id()).get();
        System.out.println(user);
        Integer authorId = article.get().getAuthor_id();
        ArticleVO articleVO = dozerMapper.map(article.get(), ArticleVO.class);
        String authorName = userRepository.findById(authorId).get().getName();
        articleVO.setAuthor_name(authorName);
        System.out.println(articleVO);
    }

    @Test
    void findAllArticlesPlusAuthername(){
        List<Article> articleList = articleRepository.findAll();
        List<ArticleVO> articleVOList = DozerUtils.mapList(articleList, ArticleVO.class);
        for (ArticleVO arricleVO : articleVOList){
            String authorName = userRepository.findById(arricleVO.getAuthor_id()).get().getName();
            arricleVO.setAuthor_name(authorName);
        }
        System.out.println(articleVOList);
    }

    @Test
    void findByTitle(){
        Article article = articleRepository.findByTitle("First");
        System.out.println(article);
    }
}