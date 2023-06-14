package com.example.myfirstprojdect.dto;

import com.example.myfirstprojdect.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleFormDTO {
    private Long id; // id 필드 추가!
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(id,title,content);
    }
}
