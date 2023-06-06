package com.api.book.bookrestapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bookrestapi.Dao.BookRepository;
import com.api.book.bookrestapi.entities.Book;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;








   // private static List<Book> list = new ArrayList<>();

   // static{
   //     list.add(new Book(12,"Java Complete Reference","XYZ"));
   //     list.add(new Book(13,"C++","ABC"));
   //     list.add(new Book(15,"Java ","DEF"));
   //     list.add(new Book(14,"let us c","GHI"));
//
   // }

// get all books
    public List<Book> getAllBooks()
    {   
       List<Book> list= (List<Book>) this.bookRepository.findAll();
        return list ;
    }

    // get the Single Book

    public Book getBookById(int id)
    {
            Book book = null;
      try {
       // book=list.stream().filter(e->e.getId()==id).findFirst().get();

       this.bookRepository.findById(id);

      } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
      }
        return book;
    }

    // adding the book

    public Book addBook(Book b)
    {
        
        Book result =bookRepository.save(b);
        return result;
    }

    //deleting book

    public void deleteBook(int bid)
    {
       // list=list.stream().filter(book->book.getId()!=bid).
        //collect(Collectors.toList());

        bookRepository.deleteById(bid);

    }


    // update the book

    public void updateBook(Book book,int bookId)
    {
       // list=list.stream().map(b->{
       //     if(b.getId()==bookId){
       //         b.setTittle(book.getTittle());
       //         b.setAuthor(book.getAuthor());
       //         }
       //         return b;
       // }).collect(Collectors.toList());

       book.setId(bookId);
       bookRepository.save(book);
    }
}
