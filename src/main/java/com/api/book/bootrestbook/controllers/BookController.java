package com.api.book.bootrestbook.controllers;

import java.util.List;
import java.util.Optional;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    
    @Autowired
    private BookService bookservice;

    //1)read video 18
    //we use this to create api in tomcat type localhost url/books we will get all output
    // @GetMapping("/books")
    // public List<Book> getBooks(){
    //     return this.bookservice.getAllBooks();
    // }


    // @GetMapping("/books/{id}")
    // public Book getBook(@PathVariable("id") int id){
    //     return this.bookservice.getBookById(id);
   
    // }
    //video 21  use of Response ENtity
    @GetMapping("/books")
    public ResponseEntity<List<Book> >getBooks(){
        List<Book> list =  this.bookservice.getAllBooks();
        if(list.size() <=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }
    
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id){
        Book b = new Book();
        b =  this.bookservice.getBookById(id);
        if(b == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(b);
    }

    //2)create
    //this is for adding book --method post video 19
    // @PostMapping("/books")
    // public Book addBook(@RequestBody Book book){
    //     Book b = this.bookservice.addBook(book);
    //     return b;
    // }
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book b = this.bookservice.addBook(book);
        if(b == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(b);
    }

    // //3)Delete
    // @DeleteMapping("/books/{bookId}")
    // public Book deleteBook(@PathVariable("bookId") int bookId){
    //     return this.bookservice.deleteBook(bookId);
    // }
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Book> deleteBook(@PathVariable("bookId") int bookId){
        
        try{
            this.bookservice.deleteBook(bookId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }
    //update
    // @PutMapping("/books/{bookId}")
    // public Book updateBook(@PathVariable("bookId") int bookId){
    //     return this.bookservice.updateBook(bookId);
    // }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(Book book,@PathVariable("bookId") int bookId){
        try{
            this.bookservice.updateBook(book, bookId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
       
    }
}
