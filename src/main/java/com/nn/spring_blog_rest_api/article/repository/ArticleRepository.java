package com.nn.spring_blog_rest_api.article.repository;

import com.nn.spring_blog_rest_api.article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}