package com.libraryapp.libraryapp.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.libraryapp.libraryapp.dto.MagazineDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
@Table(name="magazine", schema = "library-app")
@NoArgsConstructor
@AllArgsConstructor
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

	private Magazine (String magazineName, String magazineAuthor,String magazineMonth, String magazinePage){
		this.magazineName = magazineName;
		this.magazineAuthor = magazineAuthor;
		this.magazineMonth = magazineMonth;
		this.magazinePage = magazinePage;
	}

	public static Magazine of(MagazineDto magazineDto){
		return new Magazine(magazineDto.getMagazineName(),magazineDto.getMagazineAuthor(),magazineDto.getMagazineMonth(),magazineDto.getMagazinePage());
	}
}
