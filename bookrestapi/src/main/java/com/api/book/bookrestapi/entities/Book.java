package com.api.book.bookrestapi.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

@Table(name ="Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name="Book_id")
    private int id;
    private String tittle;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Author author;
    
    public Book(int id, String tittle, Author author) {
        this.id = id;
        this.tittle = tittle;
        this.author = author;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", tittle=" + tittle + ", author=" + author + "]";
    }

    
    
}
