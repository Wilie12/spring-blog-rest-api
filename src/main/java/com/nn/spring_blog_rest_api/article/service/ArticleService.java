package com.nn.spring_blog_rest_api.article.service;

import com.nn.spring_blog_rest_api.article.api.request.ArticleRequest;
import com.nn.spring_blog_rest_api.article.api.response.ArticleResponse;
import com.nn.spring_blog_rest_api.article.domain.Article;
import com.nn.spring_blog_rest_api.article.repository.ArticleRepository;
import com.nn.spring_blog_rest_api.article.support.ArticleExceptionSupplier;
import com.nn.spring_blog_rest_api.article.support.ArticleMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    public ArticleService(ArticleRepository articleRepository, ArticleMapper articleMapper) {
        this.articleRepository = articleRepository;
        this.articleMapper = articleMapper;
    }

    public List<ArticleResponse> findAll() {
        return articleRepository.findAll()
                .stream()
                .map(articleMapper::toArticleResponse)
                .collect(Collectors.toList());
    }

    public ArticleResponse create(ArticleRequest articleRequest) {
        Article article = articleRepository.save(articleMapper.toArticle(articleRequest));
        return articleMapper.toArticleResponse(article);
    }

    public void delete(Long id) {
        Article article = articleRepository
                .findById(id)
                .orElseThrow(ArticleExceptionSupplier.articleNotFound(id));
        articleRepository.deleteById(article.getId());
    }
}
