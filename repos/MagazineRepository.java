package com.libraryapp.libraryapp.repos;

import com.libraryapp.libraryapp.entities.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazineRepository extends JpaRepository<Magazine,Long> {
}
