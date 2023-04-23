package com.istad.miniprojectspring.repository;

import com.istad.miniprojectspring.model.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ArticleRepository {
    private List<Article> articleList = new ArrayList<>(){{
        add(new Article(1001,"John Wick ", " new movies triler on days ","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9oWntyNwr5nzM8-Y0lNfCoHdJ9gsAjuFC_g&usqp=CAU",new AuthorRepository().getAllAuthor().get(0)));
        add(new Article(1002,"Nano Nowhere", " new movies triler on days ","https://www.pexels.com/photo/1767434/download/",new AuthorRepository().getAllAuthor().get(0)));
        add(new Article(1003,"Koko ro", " new movies triler on days ","https://plus.unsplash.com/premium_photo-1669762659733-94b18d0803de?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8Y3V0ZSUyMHdhbGxwYXBlcnxlbnwwfHwwfHw%3D&w=1000&q=80",new AuthorRepository().getAllAuthor().get(0)));
        add(new Article(1004,"Madakco ", " new movies triler on days ","https://media.istockphoto.com/id/1211553955/photo/3d-render-abstract-vibrant-gradient-background-assorted-colorful-balls-falling-down-jumping.jpg?b=1&s=612x612&w=0&k=20&c=qJD9QdPwEDFWJWVCwzGYU_bBeQBtIXUaQLELbvFl4R0=",new AuthorRepository().getAllAuthor().get(0)));
        add(new Article(1005,"Yunaromi ", " new movies triler on days ","https://i.pinimg.com/564x/76/9a/60/769a60047076c61d72ed86fd318ba6a9.jpg",new AuthorRepository().getAllAuthor().get(0)));
    }};
    public List<Article> getArticle(){
        return articleList;
    }
    public Article getAlltitleByID(int id){
        return articleList.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }
    public void addNewArtitle(Article article){
        articleList.add(article);
    }
}
