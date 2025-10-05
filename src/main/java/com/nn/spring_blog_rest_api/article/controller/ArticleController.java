package com.nn.spring_blog_rest_api.article.controller;

import com.nn.spring_blog_rest_api.article.api.request.ArticleRequest;
import com.nn.spring_blog_rest_api.article.api.request.ArticleUpdateRequest;
import com.nn.spring_blog_rest_api.article.api.response.ArticleResponse;
import com.nn.spring_blog_rest_api.article.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> find(@PathVariable Long id) {
        ArticleResponse articleResponse = articleService.find(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(articleResponse);
    }

    @PostMapping
    public ResponseEntity<ArticleResponse> create(@RequestBody ArticleRequest articleRequest) {
        ArticleResponse articleResponse = articleService.create(articleRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(articleResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        articleService.delete(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleResponse> update(
            @PathVariable Long id,
            @RequestBody ArticleUpdateRequest articleUpdateRequest
    ) {
        ArticleResponse articleResponse = articleService.update(id, articleUpdateRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(articleResponse);
    }
}
