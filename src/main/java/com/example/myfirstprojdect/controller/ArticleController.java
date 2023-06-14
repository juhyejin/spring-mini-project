package com.example.myfirstprojdect.controller;

import com.example.myfirstprojdect.dto.ArticleFormDTO;
import com.example.myfirstprojdect.entity.Article;
import com.example.myfirstprojdect.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired // 스프링부트가 미리 생성해 놓은 객체를 가져다가 자동 연결!
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleFormDTO formDTO){
        System.out.println(formDTO.toString());

        // 1. DTO 변환! Entity!
        Article article = formDTO.toEntity();
        System.out.println(article.toString());
        // 2. Repository에게 Entity를 DB안에 저장하게 함!
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());

        return "";
    }
}
