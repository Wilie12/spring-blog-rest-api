package com.nn.spring_blog_rest_api;

import com.nn.spring_blog_rest_api.article.api.request.ArticleRequest;
import com.nn.spring_blog_rest_api.article.api.response.ArticleResponse;
import com.nn.spring_blog_rest_api.article.domain.Article;
import com.nn.spring_blog_rest_api.article.support.ArticleMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ArticleMapperTest {

    ArticleMapper articleMapper;

    @BeforeEach
    void setUp() {
        this.articleMapper = new ArticleMapper();
    }

    @Test
    void mappingArticleToResponseShouldWork() {
        Article articleToConvert = new Article("title", "content", List.of("tag1", "tag2"));

        ArticleResponse articleResponse = articleMapper.toArticleResponse(articleToConvert);

        assertThat(articleResponse.title()).isEqualTo(articleToConvert.getTitle());
        assertThat(articleResponse.content()).isEqualTo(articleToConvert.getContent());
        assertThat(articleResponse.tags()).isEqualTo(articleToConvert.getTags());
    }

    @Test
    void mappingArticleRequestToArticleShouldWork() {
        ArticleRequest articleRequestToConvert = new ArticleRequest("title", "content", List.of("tag1", "tag2"));

        Article article = articleMapper.toArticle(articleRequestToConvert);

        assertThat(article.getTitle()).isEqualTo(articleRequestToConvert.title());
        assertThat(article.getContent()).isEqualTo(articleRequestToConvert.content());
        assertThat(article.getTags()).isEqualTo(articleRequestToConvert.tags());
    }
}
