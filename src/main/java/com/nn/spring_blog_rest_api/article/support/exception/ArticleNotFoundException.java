package com.nn.spring_blog_rest_api.article.support.exception;

public class ArticleNotFoundException extends RuntimeException {

    public ArticleNotFoundException(Long id) {
        super(String.format("Article with id %d not found", id));
    }
}
