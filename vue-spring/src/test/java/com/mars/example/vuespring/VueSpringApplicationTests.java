package com.mars.example.vuespring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mars.example.vuespring.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class VueSpringApplicationTests {

    @Test
    void contextLoads() {
    }

    //手动serialization deserialization
//    @Test
//    void testJackson() throws JsonProcessingException{
//        ObjectMapper objectMapper = new ObjectMapper();
//        Article article = Article.builder()
//                .id(1)
//                .author_id(5)
//                .title("fsadfasdf")
//                .content("vcxzvczx")
//                .created_time("")
//                .last_update("today").build();
//
//        String jsonStr = objectMapper.writeValueAsString(article);
//        System.out.println(jsonStr);
//        Article article1 = objectMapper.readValue(jsonStr, Article.class);
//        System.out.println(article1);
//    }
}
