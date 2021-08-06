package com.libraryapp.libraryapp.repos;

import com.libraryapp.libraryapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
