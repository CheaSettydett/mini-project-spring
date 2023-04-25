package com.istad.miniprojectspring.controller;

import com.istad.miniprojectspring.model.Article;
import com.istad.miniprojectspring.model.request.ArtitleRequest;
import com.istad.miniprojectspring.service.ArticleService;
import com.istad.miniprojectspring.service.AuthorService;
import com.istad.miniprojectspring.service.FileUploadService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class ArticleController {
    ArticleService articleService;
    AuthorService authorService;
    FileUploadService fileUploadService;
    @Autowired
    ArticleController(ArticleService articleService,AuthorService authorService,FileUploadService fileUploadService){
        this.articleService = articleService;
        this.authorService = authorService;
        this.fileUploadService = fileUploadService;
    }
    @GetMapping("/index")
    public String getAllArticle (Model model , HttpServletRequest request){
        model.addAttribute("allArticle", articleService.getAllArtitle().stream().sorted(((o1, o2) -> o2.getId()-o1.getId())));
        return "index";
    }
    @GetMapping("/form-add-artitle")
    public String getFormAdd(Model model){
        model.addAttribute("artitle" , new ArtitleRequest());
        model.addAttribute("authors", authorService.getAllAuthor());
        return "new-article";
    }
    //method posting
    @PostMapping("/handleAddArtitle")
    public String handleAddArtitle(@ModelAttribute("artitle") @Valid ArtitleRequest artitle , BindingResult bindingResult , Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("Erorr has happened!!!!");
            model.addAttribute("authors", authorService.getAllAuthor());
            return "/new-article";
        }
        Article newArtitle = new Article();
        try {
            String filenames = "http://localhost:8080/images/" + fileUploadService.uploadFile(artitle.getFile());
            System.out.println("Filename is : " + filenames);
            newArtitle.setImgUrl(filenames);

        } catch (Exception ex) {
            newArtitle.setImgUrl("https://developers.elementor.com/docs/assets/img/elementor-placeholder-image.png");
            System.out.println("Error : " + ex.getMessage());
        }

        System.out.println("Here is value of artitle:" + artitle);
        //mapstruct vs model mapper

        newArtitle.setTitle(artitle.getTitle());
        newArtitle.setDescription((artitle.getDescription()));


        newArtitle.setAuthor(authorService.getAllAuthor().stream().filter(e -> e.getId() == artitle.getAuthorID()).findFirst().orElse(null));

        newArtitle.setId(articleService.getAllArtitle().stream().max(Comparator.comparingInt(Article::getId)).stream().toList().get(0).getId() + 1);
        articleService.addNewArtitle(newArtitle);
        return "redirect:/index";
    }
    @GetMapping("/allusers")
    String allUsers(Model model) {
        model.addAttribute("Authors", authorService.getAllAuthor());
        model.addAttribute("allArticle", articleService.getAllArtitle());
        return "allusers";
    }




}
