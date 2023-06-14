package com.example.myfirstprojdect.dto;

import com.example.myfirstprojdect.entity.Article;

public class ArticleFormDTO {
    private String title;
    private String content;
    public ArticleFormDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }
    @Override
    public String toString() {
        return "ArticleFormDTO{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Article toEntity() {
        return new Article(null,title,content);
    }
}
