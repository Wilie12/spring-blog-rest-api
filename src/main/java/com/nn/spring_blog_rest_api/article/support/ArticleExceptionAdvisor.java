package com.nn.spring_blog_rest_api.article.support;

import com.nn.spring_blog_rest_api.article.shared.api.response.ErrorMessageResponse;
import com.nn.spring_blog_rest_api.article.support.exception.ArticleNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ArticleExceptionAdvisor {
    private static final Logger LOG = LoggerFactory.getLogger(ArticleExceptionAdvisor.class);

    @ExceptionHandler(ArticleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessageResponse articleNotFound(Exception e) {
        LOG.error(e.getMessage(), e);
        return new ErrorMessageResponse(e.getLocalizedMessage());
    }
}
