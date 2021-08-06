package com.libraryapp.libraryapp.repos;

import com.libraryapp.libraryapp.entities.Newspaper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewspaperRepository extends JpaRepository<Newspaper,Long> {
}
