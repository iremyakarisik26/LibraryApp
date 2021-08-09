package com.libraryapp.libraryapp.services.impl;

import com.libraryapp.libraryapp.dto.AdminDto;
import com.libraryapp.libraryapp.dto.UserDto;
import com.libraryapp.libraryapp.entities.Admin;
import com.libraryapp.libraryapp.entities.User;
import com.libraryapp.libraryapp.repos.AdminRepository;
import com.libraryapp.libraryapp.services.IAdminService;
import javassist.NotFoundException;
import org.springframework.transaction.annotation.Transactional;

public class AdminServiceImpl implements IAdminService {
    private AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    @Override
    @Transactional
    public AdminDto updateAdmin(Long adminId, AdminDto newAdmin) throws NotFoundException {

        final Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new NotFoundException("Not Found Exception"));
        admin.setAdminMail(newAdmin.getAdminMail());
        admin.setAdminPassword(newAdmin.getAdminPassword());
        adminRepository.save(admin);
        return AdminDto.of(admin);

    }
}
