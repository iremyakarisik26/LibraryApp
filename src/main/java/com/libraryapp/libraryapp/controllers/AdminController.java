package com.libraryapp.libraryapp.controllers;


import com.libraryapp.libraryapp.dto.AdminDto;
import com.libraryapp.libraryapp.repos.AdminRepository;
import com.libraryapp.libraryapp.services.impl.AdminServiceImpl;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	private AdminRepository adminRepository;
	
	public AdminController(AdminRepository adminRepository) {
		this.adminRepository=adminRepository;
	}

	private AdminServiceImpl adminService;
	@PutMapping("/{adminId}")
	public AdminDto updateAdmin(@PathVariable Long adminId, @RequestBody AdminDto newAdmin) throws NotFoundException {
		return adminService.updateAdmin(adminId,newAdmin);
	}
}
