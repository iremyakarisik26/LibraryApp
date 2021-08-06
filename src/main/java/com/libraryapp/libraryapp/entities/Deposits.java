package com.libraryapp.libraryapp.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
@Table(name="deposits", schema = "library-app")
public class Deposits {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
    String issueDate;
    
    String deliveryDate;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name="user_id",nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    User user;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name="newspaper_id",nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    Newspaper newspaper;


    @OneToOne(fetch = LAZY)
    @JoinColumn(name="book_id",nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    Book book;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name="magazine_id",nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    Magazine magazine;

}
