package com.libraryapp.libraryapp.repos;

import com.libraryapp.libraryapp.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
}
