package com.example.myfirstprojdect.repository;

import com.example.myfirstprojdect.entity.Article;
import org.springframework.data.repository.CrudRepository;

//jpa 에서 제공하는 interface를 사용해서 쉽게 만들수 있다.
//CrudRepository를 사용해서 정의없이 간단하게 사용 2개의 파라미터를 넣어줘야함
// 첫번째 -> 관리 대상 엔티티
// 두번째 -> 관리대상 엔티티에서 대표값의 타입을 입력해줘야함
public interface ArticleRepository extends CrudRepository<Article,Long> {

}
