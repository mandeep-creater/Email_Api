package com.api.book.bookrestapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int author_id;

    private String firstname;
    private String lastname;
    private String langugae;
    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private Book book;

    public void setBook(Book book) {
        this.book = book;
    }
    public Book getBook() {
        return book;
    }
        
    public int getAuthor_id() {
        return author_id;
    }
    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getLangugae() {
        return langugae;
    }
    public void setLangugae(String langugae) {
        this.langugae = langugae;
    }
    public Author() {
    }
    public Author(int author_id, String firstname, String lastname, String langugae) {
        this.author_id = author_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.langugae = langugae;
    }
    @Override
    public String toString() {
        return "Author [author_id=" + author_id + ", firstname=" + firstname + ", lastname=" + lastname + ", langugae="
                + langugae + "]";
    }

    
    

    
}
