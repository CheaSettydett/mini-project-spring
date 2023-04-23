package com.istad.miniprojectspring.service.serviceImpl;

import com.istad.miniprojectspring.model.Article;
import com.istad.miniprojectspring.repository.ArticleRepository;
import com.istad.miniprojectspring.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    ArticleRepository articleRepository;
    ArticleServiceImpl(){
        articleRepository = new ArticleRepository();
    }

    @Override
    public List<Article> getAllArtitle() {
        return articleRepository.getArticle();
    }

    @Override
    public Article getAlltitleByID(int id) {
        return articleRepository.getAlltitleByID(id);
    }

    @Override
    public void addNewArtitle(Article article) {
        articleRepository.addNewArtitle(article);

    }
}
