package com.libraryapp.libraryapp.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.libraryapp.libraryapp.dto.MagazineDto;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
@Table(name="magazine", schema = "library-app")
public class Magazine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(columnDefinition="text")
	String magazineName;
	
	@Column(columnDefinition="text")
	String magazineAuthor;
	
	String magazineMonth;
	
	String magazinePage;


	@ManyToOne(fetch = LAZY)  // bir çok kitabın 1 user olabilir
	@JoinColumn(name="user_id",nullable = false) //bağlama amaçlı ve boş olmamalı
	@OnDelete(action= OnDeleteAction.CASCADE) // bir user silindiğinde her şeyi silinsin
	@JsonIgnore    //niye bilmiyorum , raşit beye sor.


	Magazine magazine;
	public static Magazine of(MagazineDto magazineDto){
		return new Magazine(magazineDto.getMagazineName(),magazineDto.getMagazineAuthor(),magazineDto.getMagazineMonth(),magazineDto.getMagazinePage());
	}
}
