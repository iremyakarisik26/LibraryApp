package com.libraryapp.libraryapp.services.impl;

import com.libraryapp.libraryapp.dto.UserDto;
import com.libraryapp.libraryapp.entities.User;
import com.libraryapp.libraryapp.repos.UserRepository;
import com.libraryapp.libraryapp.services.IUserService;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserDto::of)
                .collect(Collectors.toList());
    }

    @Override
    public void saveOneUser(UserDto newUser) {
        userRepository.save(User.of(newUser));
    }

    @Override
    public UserDto getOneUser(Long userId) throws NotFoundException {
        final User foundUser= userRepository.findById(userId)
               .orElseThrow(() -> new NotFoundException("User Not Found"));
        return UserDto.of(foundUser);

    }

    @Override
    @Transactional
    public UserDto updateOneUser(Long userId, UserDto newUser) throws NotFoundException {

        final User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Not Found Exception"));
        user.setUserMail(newUser.getUserMail());
        user.setUserPassword(newUser.getUserPassword());
        userRepository.save(user);
        return UserDto.of(user);
    }
    @Override
    public void deleteById(Long userId) {
      userRepository.deleteById(userId);
    }
}
