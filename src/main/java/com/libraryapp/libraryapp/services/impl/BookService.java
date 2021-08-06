package com.libraryapp.libraryapp.services.impl;

import com.libraryapp.libraryapp.dto.BookDto;
import com.libraryapp.libraryapp.entities.Book;
import com.libraryapp.libraryapp.entities.User;

import com.libraryapp.libraryapp.repos.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    BookRepository bookRepository;
    private UserServiceImpl userService;

    public BookService(BookRepository bookRepository, UserServiceImpl userService) {
        this.bookRepository = bookRepository;
        this.userService= userService;
    }

    public List<Book> getAllBooks(@RequestParam Optional<Long> userId) {
        //if(userId.isPresent())
            //return bookRepository.findByUserId(userId.get());
        return bookRepository.findAll();

    }

    public Book saveOneBook(Book newBook) {
        return bookRepository.save(newBook);
    }

    public void deleteById(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public Book getOneBookById(Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    public Book createOneBook(BookDto newBook) {
        /*User user=userService.getOneUser(newBookRequest.getUserId());
        if(user==null)
            return null;
        Book toSave= new Book();
        toSave.setId(newBookRequest.getId());
        toSave.setBookName(newBookRequest.getBookName());
        toSave.setBookAuthor(newBookRequest.getBookAuthor());
        toSave.setBookPage(newBookRequest.getBookPage());
        toSave.setUser(user);
        return bookRepository.save(toSave);*/
        return null;
    }
}
