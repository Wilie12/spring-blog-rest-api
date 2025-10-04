package com.nn.spring_blog_rest_api.article.api.response;

import java.time.ZonedDateTime;
import java.util.List;

public class ArticleResponse {
    private final long id;
    private final int version;
    private final String title;
    private final String content;
    private final List<String> tags;
    private final ZonedDateTime publishedDate;
    private final ZonedDateTime updatedDate;

    public ArticleResponse(
            long id,
            int version,
            String title,
            String content,
            List<String> tags,
            ZonedDateTime publishedDate,
            ZonedDateTime updatedDate
    ) {
        this.id = id;
        this.version = version;
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.publishedDate = publishedDate;
        this.updatedDate = updatedDate;
    }

    public long getId() {
        return id;
    }

    public int getVersion() {
        return version;
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

    public ZonedDateTime getPublishedDate() {
        return publishedDate;
    }

    public ZonedDateTime getUpdatedDate() {
        return updatedDate;
    }
}
