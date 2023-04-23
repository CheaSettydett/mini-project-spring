package com.istad.miniprojectspring.service;

import com.istad.miniprojectspring.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArtitle();
    Article getAlltitleByID (int id);
    void addNewArtitle (Article article);
}
