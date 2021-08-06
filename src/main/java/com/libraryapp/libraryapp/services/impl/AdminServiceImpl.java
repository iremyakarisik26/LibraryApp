package com.libraryapp.libraryapp.services.impl;

import com.libraryapp.libraryapp.repos.AdminRepository;
import com.libraryapp.libraryapp.services.IAdminService;

public class AdminServiceImpl implements IAdminService {
    private AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
}
