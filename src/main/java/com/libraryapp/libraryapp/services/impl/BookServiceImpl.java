package com.libraryapp.libraryapp.services.impl;

import com.libraryapp.libraryapp.dto.BookDto;
import com.libraryapp.libraryapp.dto.UserDto;
import com.libraryapp.libraryapp.entities.Book;
import com.libraryapp.libraryapp.entities.User;
import com.libraryapp.libraryapp.repos.BookRepository;
import com.libraryapp.libraryapp.services.IBookService;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements IBookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDto> getAllBooks(){
        return bookRepository.findAll().stream()
                .map(BookDto::of)
                .collect(Collectors.toList());
    }

    @Override
    public BookDto getOneBook(Long bookId) throws NotFoundException {
        final Book foundBook= bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException("Book Not Found"));
        return BookDto.of(foundBook);
    }

    @Override
    public void saveOneBook(BookDto newBook) {
        bookRepository.save(Book.of(newBook));
    }

    @Override
    public BookDto updateBook(Long bookId, BookDto newBook) throws NotFoundException {
        final Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException("Not Found Exception"));
        book.setBookName(newBook.getBookName());
        book.setBookAuthor(newBook.getBookAuthor());
        book.setBookPage(newBook.getBookPage());
        bookRepository.save(book);
        return BookDto.of(book);
    }

    @Override
    public void deleteById(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}

