package com.nn.spring_blog_rest_api.article.support;

import com.nn.spring_blog_rest_api.article.api.request.ArticleRequest;
import com.nn.spring_blog_rest_api.article.api.response.ArticleResponse;
import com.nn.spring_blog_rest_api.article.domain.Article;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapper {
    public ArticleResponse toArticleResponse(Article article) {
        return new ArticleResponse(
                article.getId(),
                article.getVersion(),
                article.getTitle(),
                article.getContent(),
                article.getTags(),
                article.getPublishedDate(),
                article.getUpdatedDate()
        );
    }

    public Article toArticle(ArticleRequest articleRequest) {
        return new Article(
                articleRequest.getTitle(),
                articleRequest.getContent(),
                articleRequest.getTags()
        );
    }
}
