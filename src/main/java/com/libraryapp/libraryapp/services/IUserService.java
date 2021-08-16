package com.libraryapp.libraryapp.services;


import com.libraryapp.libraryapp.dto.UserDto;
import javassist.NotFoundException;

import java.util.List;

public interface IUserService {


    //crud
    List<UserDto> getAllUsers();
    void saveOneUser(UserDto newUser);
    UserDto getOneUser(Long userId) throws NotFoundException;
    UserDto updateOneUser(Long userId, UserDto newUser) throws NotFoundException;
    void deleteById(Long userId);

}
