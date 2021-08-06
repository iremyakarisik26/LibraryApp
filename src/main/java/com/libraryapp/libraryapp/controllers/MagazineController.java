package com.libraryapp.libraryapp.controllers;

import java.util.List;

import com.libraryapp.libraryapp.repos.MagazineRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraryapp.libraryapp.entities.Magazine;

@RestController
@RequestMapping("/magazine")
public class MagazineController {

	private MagazineRepository magazineRepository;
	
	public MagazineController() {
		this.magazineRepository=magazineRepository;
	}
	
	@GetMapping
	public List<Magazine> getAllMagazines(){
		return magazineRepository.findAll();
	}
}
