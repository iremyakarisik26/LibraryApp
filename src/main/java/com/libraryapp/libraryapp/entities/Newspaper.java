package com.libraryapp.libraryapp.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
@Table(name="newspaper", schema = "library-app")
public class Newspaper {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(columnDefinition="text")
	String newspaperName;
	
	@Column(columnDefinition="text")
	String newspaperAuthor;
	
	@Column(columnDefinition="text")
	String newspaperDay;
	
	String newspaperPage;


	@ManyToOne(fetch = LAZY)  // bir çok kitabın 1 user olabilir
	@JoinColumn(name="user_id",nullable = false) //bağlama amaçlı ve boş olmamalı
	@OnDelete(action= OnDeleteAction.CASCADE) // bir user silindiğinde her şeyi silinsin
	@JsonIgnore    //niye bilmiyorum , raşit beye sor.
	User user;

}
