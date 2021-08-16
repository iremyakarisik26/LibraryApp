package com.libraryapp.libraryapp.services;

import com.libraryapp.libraryapp.dto.AdminDto;
import com.libraryapp.libraryapp.dto.UserDto;
import javassist.NotFoundException;

public interface IAdminService {
    AdminDto updateAdmin(Long adminId, AdminDto newAdmin) throws NotFoundException;
}
