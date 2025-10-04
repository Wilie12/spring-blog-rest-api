package com.nn.spring_blog_rest_api.article.api.request;

import java.util.List;

public record ArticleRequest(
        String title,
        String content,
        List<String> tags
) {
}
