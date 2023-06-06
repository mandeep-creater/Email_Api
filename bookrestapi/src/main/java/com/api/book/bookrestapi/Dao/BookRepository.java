package com.api.book.bookrestapi.Dao;
import org.springframework.data.repository.CrudRepository;

import com.api.book.bookrestapi.entities.Book;


public interface BookRepository extends CrudRepository<Book,Integer> {

  
    public Book findById(int id);
}
