package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.Bookrepository;


@SpringBootApplication
public class BookstoreApplication {
    
    private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }
    
    @Bean
    public CommandLineRunner bookDemo(Bookrepository repository) {
        return (args) -> {
            log.info("save a couple of books");
            repository.save(new Book("Cool Drink", "Kris Pepper", 1990, "0-3333-9961-1", 24.99));
            repository.save(new Book("Hot Egg", "John McGinn", 1980, "0-9870-9920-4", 19.99));    
            
            log.info("fetch all books");
            for (Book book : repository.findAll()) {
                log.info(book.toString());
            }

        };
    }

}