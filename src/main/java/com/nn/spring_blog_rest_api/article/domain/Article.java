package com.nn.spring_blog_rest_api.article.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Entity(name = "articles")
public class Article {
    @Id
    @GeneratedValue
    private long id;
    private int version;
    private String title;
    private String content;
    private List<String> tags;
    private ZonedDateTime publishedDate;
    private ZonedDateTime updatedDate;

    protected Article() {}

    public Article(String title, String content, List<String> tags) {
        version = 1;
        this.title = title;
        this.content = content;
        this.tags = tags;
        publishedDate = ZonedDateTime.now(ZoneId.of("UTC"));
        updatedDate = ZonedDateTime.now(ZoneId.of("UTC"));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void updateVersion() {
        version++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getTags() {
        return tags;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    public ZonedDateTime getPublishedDate() {
        return publishedDate;
    }

    public ZonedDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(ZonedDateTime updatedDate) {
        this.updatedDate = ZonedDateTime.now(ZoneId.of("UTC"));
    }
}