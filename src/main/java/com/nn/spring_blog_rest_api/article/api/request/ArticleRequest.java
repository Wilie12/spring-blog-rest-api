package com.nn.spring_blog_rest_api.article.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;

public class ArticleRequest {

    private final String title;
    private final String content;
    private final List<String> tags;

    @JsonCreator
    public ArticleRequest(String title, String content, List<String> tags) {
        this.title = title;
        this.content = content;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<String> getTags() {
        return tags;
    }
}
