package com.nn.spring_blog_rest_api.article.api.response;

import java.time.ZonedDateTime;
import java.util.List;

public record ArticleResponse(
        long id,
        int version,
        String title,
        String content,
        List<String> tags,
        ZonedDateTime publishedDate,
        ZonedDateTime updatedDate
) {
}
