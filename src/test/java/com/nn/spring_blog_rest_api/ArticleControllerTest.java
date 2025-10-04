package com.nn.spring_blog_rest_api;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.nn.spring_blog_rest_api.article.controller.ArticleController;
import com.nn.spring_blog_rest_api.article.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = ArticleController.class)
public class ArticleControllerTest {
    @Autowired
    MockMvc mvc;

    @MockitoBean
    ArticleService articleService;

    @Test
    void findAllArticlesShouldWork() throws Exception{
        mvc.perform(get("/api/v1/articles"))
                .andExpect(status().isOk());

        verify(articleService).findAll();
    }
}
