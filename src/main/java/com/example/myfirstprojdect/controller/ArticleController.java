package com.example.myfirstprojdect.controller;

import com.example.myfirstprojdect.dto.ArticleFormDTO;
import com.example.myfirstprojdect.entity.Article;
import com.example.myfirstprojdect.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class ArticleController {

    @Autowired // 스프링부트가 미리 생성해 놓은 객체를 가져다가 자동 연결!
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleFormDTO formDTO){
        // 1. DTO 변환! Entity!
        log.info(formDTO.toString());
        Article article = formDTO.toEntity();
        log.info(article.toString());
        // 2. Repository에게 Entity를 DB안에 저장하게 함!
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        return "";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id = "+ id);
        //id를 데이터로 가져옴!
        //Optional<Article> articleEntity = articleRepository.findById(id); 이렇게도 쓸수 있다
         Article articleEntity = articleRepository.findById(id).orElse(null);
        //가져온 데이터를 모델에 등록
        model.addAttribute("article", articleEntity);
        // 보여줄 페이지를 설정
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model){
        // 모든 아티클을 가져온다
        // Iterable<Article> articleEntityList = articleRepository.findAll();
        List<Article> articleEntityList = articleRepository.findAll();
        //가져온 article묶음을 뷰로 전달
        model.addAttribute("articleList",articleEntityList);
        // 뷰 페이지를 설정
        return "articles/index";
    }
}
