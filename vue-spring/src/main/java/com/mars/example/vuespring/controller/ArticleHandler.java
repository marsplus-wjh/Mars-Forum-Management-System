package com.mars.example.vuespring.controller;

import com.mars.example.vuespring.entity.Article;
import com.mars.example.vuespring.entity.ArticleVO;
import com.mars.example.vuespring.repository.ArticleRepository;
import com.mars.example.vuespring.repository.UserRepository;
import com.mars.example.vuespring.utils.DozerUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//默认json传输 jackson HttpMessageConverter Serialization Deserialization
//ObjectMapper json <=> objects
@RequestMapping("/article")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleHandler {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private UserRepository userRepository;

//    @RequestMapping(value = "/findAll/{page}/{size}", method = RequestMethod.GET)
    @GetMapping("/findAll/{page}/{size}")
    private Page<ArticleVO> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Pageable pageable = PageRequest.of(page - 1, size);
//        Page<Article> result = articleRepository.findAll(pageable);

        List<Article> articleList = articleRepository.findAll();
        List<ArticleVO> articleVOList = DozerUtils.mapList(articleList, ArticleVO.class);
        for (ArticleVO arricleVO : articleVOList){
            String authorName = userRepository.findById(arricleVO.getAuthor_id()).get().getName();
            arricleVO.setAuthor_name(authorName);
        }
        Page<ArticleVO> result = DozerUtils.listConvertToPages(articleVOList, pageable);
        return result;
    }

    @GetMapping("/ArticleFindById/{id}")
    private Article findById(@PathVariable("id") Integer id){
        return articleRepository.findById(id).get();
    }

    //RequestParam to receive form-data
    @PostMapping("/save")
    private String save(@RequestBody Article article){
        Article res = articleRepository.save(article);
        if (res != null){
            return "success";
        }else return "failure";
    }

    @PutMapping("/update")
    private String update(@RequestBody Article article){
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
