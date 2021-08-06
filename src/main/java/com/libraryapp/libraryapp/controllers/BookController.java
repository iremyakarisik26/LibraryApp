package com.libraryapp.libraryapp.controllers;

import java.util.List;
import java.util.Optional;

import com.libraryapp.libraryapp.dto.BookDto;
import com.libraryapp.libraryapp.services.impl.BookService;
import org.springframework.web.bind.annotation.*;

import com.libraryapp.libraryapp.entities.Book;

@RestController
@RequestMapping("/book")
public class BookController {
	private BookService bookService;
	
	public BookController(){
		this.bookService=bookService;
	}
	
	@GetMapping
	public List<Book> getAllBooks(@RequestParam Optional<Long> userId){
		return bookService.getAllBooks(userId);
	}
	
	@PostMapping
	public Book createBook(@RequestBody BookDto newBook) {
		return bookService.createOneBook(newBook);
	}
	@GetMapping("/{bookId}")
	public Book getOneBook(@PathVariable Long bookId){
		return bookService.getOneBookById(bookId);

	}
	@DeleteMapping("/{bookId}")
	public void deleteBook(@PathVariable Long bookId){
		bookService.deleteById(bookId);
	}


}
