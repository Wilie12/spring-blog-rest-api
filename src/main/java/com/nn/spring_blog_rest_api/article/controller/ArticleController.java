package com.nn.spring_blog_rest_api.article.controller;

import com.nn.spring_blog_rest_api.article.api.response.ArticleResponse;
import com.nn.spring_blog_rest_api.article.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public ResponseEntity<List<ArticleResponse>> findAll() {
        List<ArticleResponse> articleResponses = articleService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(articleResponses);
    }
}
