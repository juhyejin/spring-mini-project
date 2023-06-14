package com.example.myfirstprojdect.dto;

import com.example.myfirstprojdect.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleFormDTO {
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(null,title,content);
    }
}
