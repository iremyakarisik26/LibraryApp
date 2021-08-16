package com.libraryapp.libraryapp.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.libraryapp.libraryapp.dto.BookDto;
import com.libraryapp.libraryapp.dto.UserDto;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import static javax.persistence.FetchType.*;

@Entity
@Data
@Table(name="book", schema = "library-app")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(columnDefinition="text")
	String bookName;
	
	@Column(columnDefinition="text")
	String bookAuthor;
	
	String bookPage;



	private Book (String bookName, String bookAuthor, String bookPage){
		this.bookName=bookName;
		this.bookAuthor=bookAuthor;
		this.bookPage=bookPage;
	}


	Book book ;
	public static Book of(BookDto bookDto){return new Book(bookDto.getBookName(),bookDto.getBookAuthor(),bookDto.getBookPage());}
}
