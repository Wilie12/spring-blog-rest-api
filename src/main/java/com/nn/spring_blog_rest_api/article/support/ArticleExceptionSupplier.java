package com.nn.spring_blog_rest_api.article.support;

import com.nn.spring_blog_rest_api.article.support.exception.ArticleNotFoundException;

import java.util.function.Supplier;

public class ArticleExceptionSupplier {

    public static Supplier<ArticleNotFoundException> articleNotFound(Long id) {
        return () -> new ArticleNotFoundException(id);
    }
}
