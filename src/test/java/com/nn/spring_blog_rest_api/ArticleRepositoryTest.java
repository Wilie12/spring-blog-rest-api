package com.nn.spring_blog_rest_api;

import com.nn.spring_blog_rest_api.article.domain.Article;
import com.nn.spring_blog_rest_api.article.repository.ArticleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ArticleRepositoryTest {

    @Autowired
    ArticleRepository articleRepository;

    @BeforeEach
    void setUp() {
        articleRepository.saveAll(
                List.of(
                        new Article("services", "text about services", List.of("science", "service")),
                        new Article("repositories", "text about repositories", List.of("science", "repository")),
                        new Article("databases", "text about databases", List.of("test", "database"))
                )
        );
    }

    @Test
    void findAllShouldProduceAllVideos() {
        List<Article> articles = articleRepository.findAll();
        assertThat(articles).hasSize(3);
    }
}