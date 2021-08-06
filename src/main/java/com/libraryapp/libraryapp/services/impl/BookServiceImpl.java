package com.libraryapp.libraryapp.services.impl;

import com.libraryapp.libraryapp.dto.BookDto;
import com.libraryapp.libraryapp.dto.UserDto;
import com.libraryapp.libraryapp.repos.BookRepository;
import com.libraryapp.libraryapp.services.IBookService;
import org.springframework.stereotype.Service;

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
    public BookDto getOneBookById(Long id) {
        /*bookRepository.findById(bookId);
        return BookDto.of(book);*/
        return null;
    }

    @Override
    public BookDto createOneBook(BookDto newBook) {
        return null;
    }

    @Override
    public void deleteById(Long bookId) {

    }
}
