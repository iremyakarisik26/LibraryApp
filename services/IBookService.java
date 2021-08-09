package com.libraryapp.libraryapp.services;

import com.libraryapp.libraryapp.dto.BookDto;
import com.libraryapp.libraryapp.entities.Book;
import javassist.NotFoundException;
import java.util.List;


public interface IBookService {
    List<BookDto> getAllBooks();
    BookDto getOneBook(Long id)throws NotFoundException;
    void saveOneBook(BookDto newBook);
    BookDto updateBook(Long bookId, BookDto newBook) throws NotFoundException;
    void deleteById(Long bookId);
}
