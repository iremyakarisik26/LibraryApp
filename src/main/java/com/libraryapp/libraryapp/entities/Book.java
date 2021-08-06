package com.libraryapp.libraryapp.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

	@ManyToOne(fetch = LAZY) // bir çok kitabın 1 user olabilir
	@JoinColumn(name="user_id",nullable = false) //bağlama amaçlı ve boş olmamalı
	@OnDelete(action= OnDeleteAction.CASCADE) // bir user silindiğinde her şeyi silinsin
	@JsonIgnore
	User user;

}
