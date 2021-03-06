package com.example.bookstore.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface Bookrepository extends CrudRepository<Book, Long> {

    List<Book> findByTitle(String title);
    
}