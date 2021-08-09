package com.libraryapp.libraryapp.entities;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="admin", schema = "library-app")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String adminMail;
	String adminPassword;

}
