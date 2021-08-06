package com.libraryapp.libraryapp.services;

import com.libraryapp.libraryapp.dto.BookDto;

import com.libraryapp.libraryapp.dto.UserDto;
import javassist.NotFoundException;

import java.util.List;


public interface IBookService {
    List<BookDto> getAllBooks();
    BookDto getOneBookById(Long id);
    BookDto createOneBook(BookDto newBook);
    void deleteById(Long bookId);
}
