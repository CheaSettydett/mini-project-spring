package com.istad.miniprojectspring.service.serviceImpl;

import com.istad.miniprojectspring.model.Author;
import com.istad.miniprojectspring.repository.AuthorRepository;
import com.istad.miniprojectspring.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    AuthorRepository authorRepository;
    AuthorServiceImpl(){
        authorRepository = new AuthorRepository();
    }
    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.getAllAuthor();
    }
}
