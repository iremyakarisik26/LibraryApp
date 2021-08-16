package com.libraryapp.libraryapp.controllers;

import java.util.List;

import com.libraryapp.libraryapp.repos.NewspaperRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraryapp.libraryapp.entities.Newspaper;

@RestController
@RequestMapping("/newspaper")
public class NewspaperController {
	
	private NewspaperRepository newspaperRepository;
	
	public NewspaperController() {
		this.newspaperRepository= newspaperRepository;
	}
	
	@GetMapping
	public List<Newspaper> getAllNewspapers(){
		return newspaperRepository.findAll();
	}
	
}
