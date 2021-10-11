package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.Bookrepository;
import com.example.bookstore.model.Category;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookrepositoryTest {
	

    @Autowired
    private Bookrepository repository;

    @Test
    public void findByLastnameShouldReturnStudent() {
        List<Book> book = repository.findByTitle("Cool Drink");
        
        assertThat(book).hasSize(1);
        assertThat(book.get(0).getAuthor()).isEqualTo("Kris Pepper");
    }
    
    @Test
    public void createNewStudent() {
    	Book book = new Book("Hot Food", "Jan Salt", 1970, "0-3333-6961-1", 24.99, new Category("Comedy"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    

    @Test
    public void deleteNewStudent() {
    	
    	List<Book> books = repository.findByTitle("Cool Drink");
    	Book book = books.get(0);
    	long id = book.getId();
    	repository.delete(book);
    	List<Book> newBooks = repository.findByTitle("Cool Drink");
    	assertThat(newBooks).hasSize(0);
    	
    }

}
