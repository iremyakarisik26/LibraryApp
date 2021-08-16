package com.libraryapp.libraryapp.controllers;

import java.util.List;

import com.libraryapp.libraryapp.dto.MagazineDto;
import com.libraryapp.libraryapp.repos.MagazineRepository;
import com.libraryapp.libraryapp.services.impl.MagazineServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/magazine")
public class MagazineController {

	private MagazineRepository magazineRepository;
	private MagazineServiceImpl magazineService;
	
	public MagazineController(MagazineServiceImpl magazineService) {
		this.magazineService=magazineService;
	}
	
	@GetMapping
	public List<MagazineDto> getAllMagazines(){
		return magazineService.getAllMagazines();
	}

	@PostMapping
	public void saveMagazines(MagazineDto newMagazine){
		magazineService.saveMagazines(newMagazine);
	}

}
