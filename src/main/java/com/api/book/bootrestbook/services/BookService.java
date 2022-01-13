package com.api.book.bootrestbook.services;

import java.util.*;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {

    //this required for db video 23
    @Autowired
    private BookRepository bookRepository;
    //this all before db video 23
    // private static List<Book> list = new ArrayList<>();

    // static{
    //     list.add(new Book(12,"Java","XYZ"));
    //     list.add(new Book(13,"Head First java","ABC"));
    //     list.add(new Book(14,"Spring","LMN"));
    // }
    //get all book v 23 se phle ka h
    //public List<Book> getAllBooks(){return list;}

    //using custom finder refer video 23
    public List<Book> getAllBooks(){
        return (List<Book>)this.bookRepository.findAll(); 
    }

    //get one book vieo before 23
    // public Book getBookById(int id){
    //     //using java 8 collection
    //     Book book = new Book();
    //     book = list.stream().filter(e->e.getId()==id).findFirst().get();
    //     return book;
    // }

    //video 23 custome finder
    public Book getBookById(int id){
        return bookRepository.findById(id);
    }

    //video 19 adding book before 23
    // public Book addBook(Book book){
    //     list.add(book);
    //     return book;
    // }

    //video 23 ...jpa use 
    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    //video 20
    //delete data before 23
    // public Book deleteBook(int bid){
    //     Book book = new Book();
    //     book = list.stream().filter(e->e.getId()==bid).findFirst().get();
    //     list.remove(book);
    //     return book;
    // }

    //using jpa
    public void deleteBook(int bid){
       bookRepository.deleteById(bid);
    }
    //video 21 update before v 23
    // public Book updateBook(int bid){
    //     Book book = new Book();
    //     book = list.stream().filter(e->e.getId()==bid).findFirst().get();
    //     book.setTitle("Learn full Stack");
    //     return book;
    // }

    public void updateBook(Book book,int bid){
        book.setId(bid);//if id is wrrong
        bookRepository.save(book);
    }
}
