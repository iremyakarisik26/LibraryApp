package com.libraryapp.libraryapp.controllers;


import com.libraryapp.libraryapp.repos.AdminRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	private AdminRepository adminRepository;
	
	public AdminController(AdminRepository adminRepository) {
		this.adminRepository=adminRepository;
	}


}
