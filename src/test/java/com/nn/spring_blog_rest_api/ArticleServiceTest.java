package com.nn.spring_blog_rest_api;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import com.nn.spring_blog_rest_api.article.api.request.ArticleRequest;
import com.nn.spring_blog_rest_api.article.api.response.ArticleResponse;
import com.nn.spring_blog_rest_api.article.domain.Article;
import com.nn.spring_blog_rest_api.article.repository.ArticleRepository;
import com.nn.spring_blog_rest_api.article.service.ArticleService;
import com.nn.spring_blog_rest_api.article.support.ArticleMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ArticleServiceTest {

    ArticleService articleService;
    @Mock
    ArticleRepository articleRepository;

    ArticleMapper articleMapper;

    @BeforeEach
    void setUp() {
        articleMapper = new ArticleMapper();
        this.articleService = new ArticleService(articleRepository, articleMapper);
    }

    @Test
    void findAllArticlesShouldReturnAll() {
        // given
        Article article1 = new Article("services", "text about services", List.of("science", "service"));
        Article article2 = new Article("repositories", "text about repositories", List.of("science", "repository"));
        Article article3 = new Article("databases", "text about databases", List.of("test", "database"));
        when(articleRepository.findAll()).thenReturn(List.of(article1, article2, article3));

        // when
        List<ArticleResponse> articles = articleService.findAll();

        // then
        assertThat(articles).containsExactly(
                articleMapper.toArticleResponse(article1),
                articleMapper.toArticleResponse(article2),
                articleMapper.toArticleResponse(article3)
        );
    }

    @Test
    void findArticleShouldReturnTheSameData() {
        // given
        Article articleToBeFound = new Article("title", "content", List.of("tag1", "tag2"));
        when(articleRepository.findById(any(Long.class))).thenReturn(Optional.of(articleToBeFound));

        // when
        ArticleResponse foundArticle = articleService.find(articleToBeFound.getId());

        // then
        assertThat(foundArticle).isEqualTo(articleMapper.toArticleResponse(articleToBeFound));
    }

    @Test
    void createArticleShouldReturnTheSameData() {
        // given
        Article articleToCreate = new Article("title", "content", List.of("tag1", "tag2"));
        when(articleRepository.save(Mockito.any(Article.class))).thenReturn(articleToCreate);

        // when
        ArticleResponse articleResponse = articleService
                .create(new ArticleRequest("title", "content", List.of("tag1", "tag2")));

        // then
        assertThat(articleResponse.title()).isEqualTo(articleToCreate.getTitle());
        assertThat(articleResponse.content()).isEqualTo(articleToCreate.getContent());
        assertThat(articleResponse.tags()).isEqualTo(articleToCreate.getTags());
    }

    @Test
    void deleteArticleShouldWork() {
        // given
        Article articleToDelete = new Article("title", "content", List.of("tag1", "tag2"));
        when(articleRepository.findById(any(Long.class))).thenReturn(Optional.of(articleToDelete));

        // when
        articleService.delete(articleToDelete.getId());

        // then
        verify(articleRepository).findById(articleToDelete.getId());
        verify(articleRepository).deleteById(articleToDelete.getId());
    }
}
