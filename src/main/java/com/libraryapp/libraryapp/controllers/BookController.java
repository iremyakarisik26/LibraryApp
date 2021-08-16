package com.libraryapp.libraryapp.controllers;

import java.util.List;
import com.libraryapp.libraryapp.dto.BookDto;
import com.libraryapp.libraryapp.services.impl.BookServiceImpl;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
public class BookController {

	private BookServiceImpl bookService;

	public BookController(BookServiceImpl bookService) {
		this.bookService=bookService;
	}
	
	@GetMapping
	public List<BookDto> getAllBooks(){
		return bookService.getAllBooks();
	}


	@PostMapping
	public ResponseEntity<?> createOneBook(@RequestBody BookDto newBook) {
		bookService.saveOneBook(newBook);
		return ResponseEntity.ok("Created");
	}
	@PutMapping("/{bookId}")
	public BookDto updateBook(@PathVariable Long bookId,@RequestBody BookDto newBook) throws NotFoundException{
		return bookService.updateBook(bookId,newBook);
	}

	@GetMapping("/{bookId}")
	public BookDto getOneBook(@PathVariable Long bookId) throws NotFoundException {
		return bookService.getOneBook(bookId);
	}
	@DeleteMapping("/{bookId}")
	public void deleteBook(@PathVariable Long bookId){
		bookService.deleteById(bookId);
	}


}
